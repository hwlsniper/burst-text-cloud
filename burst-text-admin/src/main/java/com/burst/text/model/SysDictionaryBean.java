package com.burst.text.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysDictionaryBean implements Serializable {

    private String code;
    private String name;
    private String img;
}
