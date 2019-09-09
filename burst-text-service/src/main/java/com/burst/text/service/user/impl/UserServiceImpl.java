package com.burst.text.service.user.impl;

import com.burst.text.annotation.Log;
import com.burst.text.core.wechat.WechatService;
import com.burst.text.dto.UserTokenBean;
import com.burst.text.entity.TabUserInfo;
import com.burst.text.entity.TabUserInfoExample;
import com.burst.text.entity.TabUserWechat;
import com.burst.text.excepte.BizException;
import com.burst.text.mapper.TabUserInfoMapper;
import com.burst.text.mapper.TabUserWechatMapper;
import com.burst.text.service.user.UserLoginRecordService;
import com.burst.text.service.user.UserService;
import com.burst.text.service.user.UserTokenService;
import com.burst.text.util.IdWorker;
import com.burst.text.util.Result;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * 用户 service
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public static final IdWorker idWork = new IdWorker();

    @Autowired
    private WechatService wechatService;

    @Autowired
    private UserTokenService tokenService;

    @Autowired
    private UserLoginRecordService loginRecordService;

    @Autowired
    private TabUserInfoMapper userInfoMapper;

    @Autowired
    private TabUserWechatMapper userWechatMapper;

    /**
     * 微信授权获取用户信息,并保存
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    @Log(operationType = "authorizeUser操作", operationName = "微信授权获取微信用户信息,并登录")
    public Result authorizeUser(HttpServletRequest request, HttpServletResponse response) {
        Result result = Result.responseSuccess();
        try {
            UserTokenBean userInfo = wechatService.getWechatUserInfo(request, response);
            if (null == userInfo) {
                result.setCode(400);
                result.setMsg("微信授权失败!");
                return result;
            }

            if (StringUtils.isNotBlank(userInfo.getUserId())) {
                String userToken = StringUtils.isBlank(userInfo.getUserToken()) ? tokenService.getUserToken(userInfo.getUserId()) : userInfo.getUserToken();
                result.setData(userToken);
                return result;
            }

            result = saveUser(userInfo);
        } catch (Exception ex) {
            logger.error("异常方法:{}异常信息:{}", UserServiceImpl.class.getName() + ".authorizeUser", ex.getMessage());
            //手动回滚事物
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.setCode(400);
            result.setMsg("微信授权失败!");
        }
        return result;
    }

    /**
     * 保存用户信息
     *
     * @param userBean
     * @return
     * @throws BizException
     */
    @Override
    @Log(operationType = "saveUser操作", operationName = "保存用户信息")
    @Transactional(rollbackFor = BizException.class)
    public Result saveUser(UserTokenBean userBean) throws BizException {
        Result result = Result.responseSuccess();
        try {
            //保存用户信息
            String userId = idWork.nextId();
            TabUserInfo userInfo = new TabUserInfo();
            userInfo.setId(userId);
            userInfo.setNickName(userBean.getNickName());
            userInfo.setHeadIcon(userBean.getHeadIcon());
            userInfoMapper.insertSelective(userInfo);

            //保存用户和openid、unionid 关系
            TabUserWechat userWechat = new TabUserWechat();
            userWechat.setId(idWork.nextId());
            userWechat.setUserId(userId);
            userWechat.setOpenid(userBean.getOpenid());
            userWechat.setUnionid(userBean.getUnionid());
            userWechatMapper.saveUserWechat(userWechat);

            //记录用户登录时间
            loginRecordService.saveUserLoginRecord(userInfo.getId());

            //生成用户 token
            result.setData(tokenService.getUserToken(userInfo.getId()));
        } catch (Exception ex) {
            logger.error("异常方法:{}异常信息:{}", UserServiceImpl.class.getName() + ".saveUser", ex.getMessage());
            throw new BizException(400, "保存用户信息失败!");
        }
        return result;
    }

    /**
     * 通过条件 获取 用户信息
     *
     * @param example
     * @return
     */
    @Override
    public Result queryUser(TabUserInfoExample example) {
        Result result = Result.responseSuccess();
        try {
            userInfoMapper.selectByExample(example);
        } catch (Exception ex) {

        }
        return result;
    }

    /**
     * 通过 user_token 获取 用户信息
     *
     * @param
     * @return
     */
    @Override
    public TabUserInfo getUserInfo() {
        return userInfoMapper.selectByPrimaryKey(tokenService.queryUserIdForToken());
    }

    @Override
    public TabUserInfo queryPlatformInfo() {
        return userInfoMapper.queryPlatformInfo();
    }

    /**
     * 通过 token 获取 用户信息
     *
     * @return
     */
    @Override
    public Result queryUser() {
        Result result = Result.responseSuccess();
        TabUserInfo userInfo = userInfoMapper.selectByPrimaryKey(tokenService.queryUserIdForToken());
        if (null == userInfo) {
            result.setCode(400);
            result.setMsg("未获取到用户信息!");
            return result;
        }
        result.setData(userInfo);
        return result;
    }

    /**
     * 通过微信的 unionid 获取用户信息
     *
     * @param unionid
     * @return
     */
    @Override
    public UserTokenBean queryUserInfo(String unionid, String openid) {
        Map<String, Object> param = new HashMap<>();
        param.put("unionid", unionid);
        param.put("openid", openid);
        return userInfoMapper.queryUserInfoByWechat(param);
    }

    /**
     * 修改用户信息 (根据用户 user_token 获取到用户ID)
     *
     * @param userInfo
     * @return
     */
    @Override
    public Result modifyUserInfo(TabUserInfo userInfo) {
        Result result = Result.responseSuccess();
        try {
            String userId = tokenService.queryUserIdForToken();
            if (StringUtils.isBlank(userId)) {
                result.setCode(400);
                result.setMsg("用户未登录,无法修改用户信息!");
                return result;
            }
            //TabUserInfo userinfo = userInfoMapper.selectByPrimaryKey(userId);
            userInfo.setId(userId);
            userInfoMapper.updateByPrimaryKeySelective(userInfo);
        } catch (Exception ex) {
            logger.error("异常方法:{}异常信息:{}", UserServiceImpl.class.getName() + ".modifyUserInfo", ex.getMessage());
            throw new BizException(400, "修改用户信息失败!");
        }
        return result;
    }

    /**
     * 修改用户信息, 用户ID已包含在 userInfo 中
     *
     * @param userInfo
     * @return
     */
    @Override
    public Result updateUserInfo(TabUserInfo userInfo) {
        Result result = Result.responseSuccess();
        try {
            userInfoMapper.updateByPrimaryKeySelective(userInfo);
        } catch (Exception ex) {
            logger.error("异常方法:{}异常信息:{}", UserServiceImpl.class.getName() + ".updateUserInfo", ex.getMessage());
            throw new BizException(400, "修改用户信息失败!");
        }
        return result;
    }
}
