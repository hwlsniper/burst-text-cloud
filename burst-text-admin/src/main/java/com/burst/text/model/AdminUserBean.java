package com.burst.text.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AdminUserBean implements Serializable {

    private String id;
    private String userName;
    private String passWord;
    private String headIcon;
    private String userId;
    private Integer isEnable;
    private Date createdDate;
    private Date updatedDate;
}
