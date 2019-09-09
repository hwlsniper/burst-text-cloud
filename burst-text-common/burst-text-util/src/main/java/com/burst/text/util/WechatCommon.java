package com.burst.text.util;

/**
 * @author Administrator
 * 微信公众号相关常量
 */
public class WechatCommon {

    /**
     * 获取 user_token 的 URL
     */
    public static final String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

    public static final String WECHAT_SNSAPI_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    public static final String WECHAT_APPID = "wx6883e65e0e9d462c";

    public static final String WECHAT_SECRET = "91ef5f37a623cd406e8909ce8745c5a7";


}
