package com.burst.text.entity;

import com.burst.text.util.JsonURLDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class TabPosterTemplate implements Serializable {

    private String id;
    private String posterTitle;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL, using = JsonURLDateSerializer.class)
    private String minPoster;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL, using = JsonURLDateSerializer.class)
    private String maxPoster;
    private String posterType;
    private BigDecimal price;
    private BigDecimal originalPrice;
    private String isEnable;
    private Date createdDate;
    private Date updatedDate;
    private String useScope;
}
