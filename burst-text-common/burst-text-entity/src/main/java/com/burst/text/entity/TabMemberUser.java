package com.burst.text.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TabMemberUser implements Serializable {

    private String id;
    private String userId;
    private String memberGrade;
    private Date startTime;
    private Date endTime;
    private Date createdDate;
}
