package com.burst.text.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UploadBean implements Serializable {

    private Integer multi;

    private String fileType;

    private Integer maxSize;

    private String fileExt;

    private String fileDir;
}
