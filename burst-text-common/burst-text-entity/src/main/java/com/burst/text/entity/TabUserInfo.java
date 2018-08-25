package com.burst.text.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class TabUserInfo implements Serializable {
    private String id;

    private String userName;

    private String headIcon;

    private String busCode;

    private String position;

    private String mobile;

    private String nickName;

    private String wxqrCode;

    private String openid;

    private String unionid;

    private Date createdDate;

    private Date updatedDate;

    private int isRegister;

    @Override
    public String toString() {
        return "TabUserInfo{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", headIcon='" + headIcon + '\'' +
                ", busCode='" + busCode + '\'' +
                ", position='" + position + '\'' +
                ", mobile='" + mobile + '\'' +
                ", nickName='" + nickName + '\'' +
                ", wxqrCode='" + wxqrCode + '\'' +
                ", openid='" + openid + '\'' +
                ", unionid='" + unionid + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", isRegister=" + isRegister +
                '}';
    }
}