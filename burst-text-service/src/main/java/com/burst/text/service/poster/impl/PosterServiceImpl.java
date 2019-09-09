package com.burst.text.service.poster.impl;

import com.burst.text.dto.PosterUserInfo;
import com.burst.text.entity.TabMemberUser;
import com.burst.text.entity.TabPosterTemplate;
import com.burst.text.entity.TabSysDictionary;
import com.burst.text.entity.TabUserInfo;
import com.burst.text.mapper.TabMemberUserMapper;
import com.burst.text.mapper.TabPosterTemplateMapper;
import com.burst.text.mapper.TabUserInfoMapper;
import com.burst.text.page.BTPage;
import com.burst.text.service.poster.PosterService;
import com.burst.text.service.user.UserService;
import com.burst.text.service.user.UserTokenService;
import com.burst.text.util.Result;
import com.burst.text.util.SysCommonConstant;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 海报 service
 */
@Service
public class PosterServiceImpl implements PosterService {

    private static final Logger logger = LoggerFactory.getLogger(PosterServiceImpl.class);

    @Autowired
    private TabPosterTemplateMapper posterMapper;

    @Autowired
    private TabMemberUserMapper memberUserMapper;

    @Autowired
    private TabUserInfoMapper userInfoMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserTokenService tokenService;

    /**
     * 获取海报类型
     *
     * @return
     */
    @Override
    public Result queryPosterType() {
        Result result = Result.responseSuccess();
        try {
            List<TabSysDictionary> posterTypes = posterMapper.queryPosterType();
            result.setData(posterTypes);
        } catch (Exception ex) {
            logger.error("异常方法:{}异常信息:{}", PosterServiceImpl.class.getName() + ".queryPosterType", ex.getMessage());
        }
        return result;
    }

    /**
     * 获取海报列表数据
     *
     * @param param
     * @return
     */
    @Override
    public Result queryPosterList(Map<String, Object> param, int pageNum, int pageSize) {
        Result result = Result.responseSuccess();
        try {
            List<TabPosterTemplate> list = new ArrayList<>();
            PageHelper.startPage(pageNum, pageSize);
            list = posterMapper.queryPosterTempList(param);
            BTPage<TabPosterTemplate> pages = new BTPage<>(list);
            result.setData(pages);
        } catch (Exception ex) {
            logger.error("异常方法:{}异常信息:{}", PosterServiceImpl.class.getName() + ".queryPosterList", ex.getMessage());
        }
        return result;
    }

    /**
     * 获取海报信息
     *
     * @param param
     * @return
     */
    @Override
    public Result queryPoster(Map<String, Object> param) {
        Result result = Result.responseSuccess();
        try {
            //查询海报
            Map<String, String> map = posterMapper.queryPosterInfo(param);
            TabUserInfo userInfo = userService.getUserInfo();
            Integer isMember = SysCommonConstant.DEFAULT_COMMON_ONE;
            //如果用户没有登录,则显示平台信息
            if (null == userInfo) {
                userInfo = userService.queryPlatformInfo();
                isMember = SysCommonConstant.DEFAULT_COMMON_ZERO;
            }

            param.clear();
            param.put("userId", tokenService.queryUserIdForToken());
            TabMemberUser memberUser = memberUserMapper.queryMemberUser(param);
            if (null == memberUser) {
                userInfo.setWxqrCode(userInfoMapper.queryPlatformQrCode());
                isMember = SysCommonConstant.DEFAULT_COMMON_ZERO;
            }

            result.setData(getPosterUserInfo(userInfo, map.get("maxPoster"), isMember));
        } catch (Exception ex) {
            logger.error("异常方法:{}异常信息:{}", PosterServiceImpl.class.getName() + ".queryPoster", ex.getMessage());
        }
        return result;
    }

    /**
     * 组装数据
     *
     * @param userInfo
     * @param maxPoster
     * @param isMember
     * @return
     */
    private PosterUserInfo getPosterUserInfo(TabUserInfo userInfo, String maxPoster, Integer isMember) {
        PosterUserInfo posterUser = new PosterUserInfo();
        posterUser.setUserName(userInfo.getUserName());
        posterUser.setHeadIcon(userInfo.getHeadIcon());
        posterUser.setMobile(userInfo.getMobile());
        posterUser.setNickName(userInfo.getNickName());
        posterUser.setPosition(userInfo.getPosition());
        posterUser.setWxqrCode(userInfo.getWxqrCode());
        posterUser.setMaxPoster(maxPoster);
        posterUser.setIsMember(isMember);
        return posterUser;
    }

    /**
     * 获取用户姓名、头像、电话、二维码(或平台的)
     *
     * @param flag
     * @return
     */
    @Override
    public Result queryUserInfo(int flag) {
        Result result = Result.responseSuccess();
        try {
            //获取用户信息(尽量少量的数据,减少流量的损耗)
            TabUserInfo userInfo = userService.getUserInfo();
            //获取平台二维码
            if (flag == SysCommonConstant.DEFAULT_COMMON_ONE) {
                String qrCode = userInfoMapper.queryPlatformQrCode();
                userInfo.setWxqrCode(qrCode);
            }
        } catch (Exception ex) {
            logger.error("异常方法:{}异常信息:{}", PosterServiceImpl.class.getName() + ".queryUserInfo", ex.getMessage());
        }
        return result;
    }

    /**
     * 保存海报信息
     *
     * @param poster
     * @return
     */
    @Override
    public Result savePoster(TabPosterTemplate poster) {
        Result result = Result.responseSuccess();
        posterMapper.savePoster(poster);
        return result;
    }
}
