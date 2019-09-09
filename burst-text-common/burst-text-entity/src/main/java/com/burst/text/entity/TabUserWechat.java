package com.burst.text.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户和微信用户 openid 和 unionid 关联
 *
 * @author Administrator
 */
@Data
public class TabUserWechat implements Serializable {

    private String id;
    private String userId;
    private String openid;
    private String unionid;
    private Date createdDate;
    private Date updatedDate;

    @Override
    public String toString() {
        return "TabUserWechat{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", openid='" + openid + '\'' +
                ", unionid='" + unionid + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
