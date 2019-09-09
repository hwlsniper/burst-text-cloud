package com.burst.text.entity;

import com.burst.text.util.JsonURLDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class TabCourseInfo implements Serializable {
    private String id;
    private String couserTitle;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL, using = JsonURLDateSerializer.class)
    private String courseImg;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL, using = JsonURLDateSerializer.class)
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
