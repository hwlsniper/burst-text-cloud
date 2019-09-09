package com.burst.text.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserTokenBean implements Serializable {

    private String userId;
    private String nickName;
    private String mobile;
    private String headIcon;
    private String openid;
    private String unionid;
    private String userToken;
}
