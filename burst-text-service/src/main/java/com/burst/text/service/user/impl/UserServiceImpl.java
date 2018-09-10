package com.burst.text.service.user.impl;

import com.burst.text.annotation.Log;
import com.burst.text.core.wechat.WechatService;
import com.burst.text.entity.TabUserInfo;
import com.burst.text.entity.TabUserInfoExample;
import com.burst.text.excepte.BizException;
import com.burst.text.mapper.TabUserInfoMapper;
import com.burst.text.service.user.UserLoginRecordService;
import com.burst.text.service.user.UserService;
import com.burst.text.service.user.UserTokenService;
import com.burst.text.util.IdWorker;
import com.burst.text.util.Result;
import com.burst.text.util.SysCommonConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
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
    private TabUserInfoMapper userInfoMapper;

    @Autowired
    private UserLoginRecordService loginRecordService;

    /**
     * 微信授权获取用户信息,并保存
     * @param request
     * @param response
     * @return
     */
    @Override
    @Log(operationType="authorizeUser操作",operationName="微信授权获取微信用户信息,并登录")
    public Result authorizeUser(HttpServletRequest request, HttpServletResponse response){
        Result result = Result.responseSuccess();
        try{
            TabUserInfo userInfo = wechatService.getWechatUserInfo(request, response);
            if(null == userInfo){
                result.setCode(400);
                result.setMsg("微信授权失败!");
            }

            if(userInfo.getIsRegister() == SysCommonConstant.DEFAULT_COMMON_ONE){
                result.setData(tokenService.getUserToken(userInfo.getId()));
                return result;
            }

            result = saveUser(userInfo);
        }catch (Exception ex){
            logger.error("异常方法:{}异常信息:{}", UserServiceImpl.class.getName()+".authorizeUser", ex.getMessage());
            //手动回滚事物
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.setCode(400);
            result.setMsg("微信授权失败!");
        }
        return result;
    }

    @Override
    @Log(operationType="saveUser操作",operationName="保存用户信息")
    @Transactional(rollbackFor=BizException.class)
    public Result saveUser(TabUserInfo userInfo) throws BizException {
        Result result = Result.responseSuccess();
        try {
            //保存用户信息
            userInfo.setId(idWork.nextId()+"");
            userInfoMapper.insertSelective(userInfo);

            //记录用户登录时间
            loginRecordService.saveUserLoginRecord(userInfo.getId());

            //生成用户 token
            result.setData(tokenService.getUserToken(userInfo.getId()));
        }catch (Exception ex){
            logger.error("异常方法:{}异常信息:{}", UserServiceImpl.class.getName()+".saveUser", ex.getMessage());
            throw new BizException(400, "保存用户信息失败!");
        }
        return result;
    }

    /**
     * 获取 用户信息
     * @param example
     * @return
     */
    @Override
    public Result queryUser(TabUserInfoExample example){
        Result result = Result.responseSuccess();
        try {
            userInfoMapper.selectByExample(example);
        }catch (Exception ex){

        }
        return result;
    }

    /**
     * 获取 用户信息
     * @return
     */
    @Override
    public Result queryUser(){
        Result result = Result.responseSuccess();
        TabUserInfo userInfo = userInfoMapper.selectByPrimaryKey(tokenService.queryUserIdForToken());
        if(null == userInfo){
            result.setCode(400);
            result.setMsg("未获取到用户信息!");
            return result;
        }
        result.setData(userInfo);
        return result;
    }

    /**
     * 通过微信的 unionid 获取用户信息
     * @param unionid
     * @return
     */
    @Override
    public TabUserInfo queryUserInfo(String unionid){
        TabUserInfoExample example = new TabUserInfoExample();
        TabUserInfoExample.Criteria criteria = example.createCriteria();
        List<TabUserInfo> userInfos = userInfoMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(userInfos)){
            if(null != userInfos.get(0)){
                return userInfos.get(0);
            }
        }
        return null;
    }

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    @Override
    public Result modifyUserInfo(TabUserInfo userInfo){
        Result result = Result.responseSuccess();
        try{
            TabUserInfo userinfo = userInfoMapper.selectByPrimaryKey(tokenService.queryUserIdForToken());
            userInfo.setId(userinfo.getId());
            userInfoMapper.updateByPrimaryKeySelective(userInfo);
        }catch(Exception ex){
            logger.error("异常方法:{}异常信息:{}", UserServiceImpl.class.getName()+".modifyUserInfo", ex.getMessage());
            throw new BizException(400, "修改用户信息失败!");
        }
        return result;
    }
}
