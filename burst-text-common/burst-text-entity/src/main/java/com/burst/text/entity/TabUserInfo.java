package com.burst.text.entity;

import com.burst.text.util.JsonURLDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL, using = JsonURLDateSerializer.class)
    private String headIcon;

    private String busCode;

    private String position;

    private String mobile;

    private String nickName;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL, using = JsonURLDateSerializer.class)
    private String wxqrCode;

    private String userType;

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
                ", userType='" + userType + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", isRegister=" + isRegister +
                '}';
    }
}