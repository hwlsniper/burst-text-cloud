package com.burst.text.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class TabPosterTemplate implements Serializable {

    private String id;
    private String minPoster;
    private String maxPoster;
    private String posterType;
    private BigDecimal price;
    private BigDecimal originalPrice;
    private String isEnable;
    private Date createdDate;
    private Date updatedDate;
}
