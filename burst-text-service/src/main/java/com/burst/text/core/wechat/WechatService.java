package com.burst.text.core.wechat;

import com.burst.text.entity.TabUserInfo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * 微信相关接口
 */
@Service
public interface WechatService {

    /**
     * 根据 request 对象传进来的 code, 获取微信用户信息
     * @param request
     * @param response
     * @return
     */
    TabUserInfo getWechatUserInfo(HttpServletRequest request, HttpServletResponse response);

    /**
     * 根据 access_token 和 openid 获取微信用户信息
     * @param accessToken
     * @param openid
     * @return
     */
    TabUserInfo getWechatUserInfo(String accessToken, String openid);
}
