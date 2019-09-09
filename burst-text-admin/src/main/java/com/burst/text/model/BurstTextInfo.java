package com.burst.text.model;

import lombok.Data;

import java.util.List;

@Data
public class BurstTextInfo extends BurstTextBean {
    private String content;
    private String shortTitle;
    private String burstAscripte;
    private String userId;
    private String burstSource;
    private List<String> titleImgs;
}
