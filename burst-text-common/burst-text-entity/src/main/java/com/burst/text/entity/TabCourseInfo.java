package com.burst.text.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class TabCourseInfo implements Serializable {
    private String id;
    private String couserTitle;
    private String courseImg;
    private String couserUrl;
    private String couserClass;
    private String couserType;
    private String useScope;
    private BigDecimal price;
    private BigDecimal originalPrice;
    private int isEnable;
    private Date createdDate;
    private Date updatedDate;

}
