package com.burst.text.core.wechat.impl;

import com.alibaba.fastjson.JSONObject;
import com.burst.text.core.wechat.WechatService;
import com.burst.text.entity.TabUserInfo;
import com.burst.text.entity.TabUserInfoExample;
import com.burst.text.mapper.TabUserInfoMapper;
import com.burst.text.service.user.UserService;
import com.burst.text.util.HttpUtil;
import com.burst.text.util.SysCommonConstant;
import com.burst.text.util.WechatAuthorizeResult;
import com.burst.text.util.WechatCommon;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * 微信相关接口
 */
public class WechatServiceImpl implements WechatService {

    private static final Logger logger = LoggerFactory.getLogger(WechatServiceImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private TabUserInfoMapper userInfoMapper;


    /**
     * 根据 request 对象传进来的 code, 获取微信用户信息
     * @param request
     * @param response
     * @return
     */
    @Override
    public TabUserInfo getWechatUserInfo(HttpServletRequest request, HttpServletResponse response){
        try{
            /** 将请求、响应的编码均设置为 UTF-8（防止中文乱码） */
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            String code = request.getParameter("code");
            System.out.println("******************code=" + code);
            String get_access_token_url = WechatCommon.GET_ACCESS_TOKEN_URL.replace("APPID", WechatCommon.WECHAT_APPID).replace("SECRET", WechatCommon.WECHAT_SECRET).replace("CODE", code);
            WechatAuthorizeResult wechatResult = this.doAuthorize(get_access_token_url);

            if(null == wechatResult){
                return null;
            }

            if(StringUtils.isNotBlank(wechatResult.getUnionid())){
                //根据 unionid 获取用户信息
                TabUserInfo userInfo = userService.queryUserInfo(wechatResult.getUnionid());
                if(null != userInfo){
                    userInfo.setIsRegister(SysCommonConstant.DEFAULT_COMMON_ONE);
                    return userInfo;
                }
            }

            /** 如果 unioinid 为空,则是静态授权,不为空则是非静态授权 */
            return this.getWechatUserInfo(wechatResult.getAccessToken(), wechatResult.getOpenid());
        }catch (Exception e){
            logger.error("WechatServiceImpl getWechatUserInfo Exception is:"+e.getMessage());
            return null;
        }
    }

    /**
     * 根据 access_token 和 openid 获取微信用户信息
     * @param accessToken
     * @param openid
     * @return
     */
    @Override
    public TabUserInfo getWechatUserInfo(String accessToken, String openid){
        try{
            String wechat_snsapi_url = WechatCommon.WECHAT_SNSAPI_URL.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openid);
            WechatAuthorizeResult wechatResult = this.doAuthorize(wechat_snsapi_url);
            if(null == wechatResult){
                return null;
            }

            if(StringUtils.isNotBlank(wechatResult.getUnionid())){
                //根据 unionid 获取用户信息
                TabUserInfo userInfo = userService.queryUserInfo(wechatResult.getUnionid());
                if(null != userInfo){
                    userInfo.setIsRegister(SysCommonConstant.DEFAULT_COMMON_ONE);
                    return userInfo;
                }
            }

            TabUserInfo userInfo = new TabUserInfo();
            userInfo.setOpenid(wechatResult.getOpenid());
            userInfo.setUnionid(wechatResult.getUnionid());
            userInfo.setNickName(wechatResult.getNickname());
            userInfo.setHeadIcon(wechatResult.getHeadimgurl());

            //此处将头像上传至服务器

            return userInfo;
        }catch (Exception e){
            logger.error("WechatServiceImpl getWechatUserInfo Exception is:"+e.getMessage()+" === accessToken =" + accessToken);
            return null;
        }
    }

    /**
     * 发起获取 access_token 的请求,获取数据并解析,返回解析后的数据
     * @param url
     * @return
     */
    private WechatAuthorizeResult doAuthorize(String url) {
        try {
            WechatAuthorizeResult authorizeResult = null;
            logger.info("获取微信用户信息URL："+url);
            String json = HttpUtil.doHttpGetJson(url);
            logger.info("authorize_login_result:"+json);
            JSONObject jsonObject = JSONObject.parseObject(json);
            String openid = jsonObject.getString("openid");
            String unionid = jsonObject.getString("unionid");
            String accessToken = jsonObject.get("access_token")==null?"":jsonObject.getString("access_token");
            if(StringUtils.isEmpty(openid) || StringUtils.isEmpty(unionid) || json.indexOf("errcode") !=-1){
                return null;
            }
            String headimgurl = jsonObject.getString("headimgurl");
            String nickname = jsonObject.getString("nickname");
            authorizeResult = new WechatAuthorizeResult();
            authorizeResult.setOpenid(openid);
            authorizeResult.setUnionid(unionid);
            authorizeResult.setAccessToken(accessToken);
            authorizeResult.setHeadimgurl(headimgurl);
            authorizeResult.setNickname(nickname);
            return authorizeResult;
        } catch (Exception e) {
            logger.error("WechatServiceImpl doAuthorize Exception is:"+e.getMessage());
            return null;
        }
    }
}