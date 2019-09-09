package com.burst.text.entity;

import com.burst.text.util.JsonURLDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Date;

@Data
public class TabSysDictionary {
    private String id;

    private String code;

    private String name;

    private Integer seq;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL, using = JsonURLDateSerializer.class)
    private String img;

    private String dataType;

    private Integer isEnable;

    private Date createdDate;

    private Date updatedDate;
}