package com.burst.text.model;

import com.burst.text.util.JsonURLDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;

@Data
public class BurstTextBean implements Serializable {

    private String burstId;
    public String title;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL, using = JsonURLDateSerializer.class)
    public String titleImg;
    public String burstType;
    public String burstTypeName;
    public Integer browseNum;
    public Integer shareNum;
    public Integer isTop;
    public String topName;
    public Integer isEnable;
    public String publicStatus;
    public String updatedDate;
}
