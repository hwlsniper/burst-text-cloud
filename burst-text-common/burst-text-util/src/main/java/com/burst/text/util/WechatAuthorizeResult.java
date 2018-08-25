package com.burst.text.util;

import lombok.Data;

/**
 * @author Administrator
 * 微授权获取到的信息
 */
@Data
public class WechatAuthorizeResult {
    private String openid;
    private String unionid;
    private String accessToken;
    private String headimgurl;
    private String nickname;
}
