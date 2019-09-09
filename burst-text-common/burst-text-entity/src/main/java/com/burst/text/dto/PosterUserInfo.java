package com.burst.text.dto;

import com.burst.text.util.JsonURLDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;

@Data
public class PosterUserInfo implements Serializable {

    private String userName;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL, using = JsonURLDateSerializer.class)
    private String headIcon;
    private String mobile;
    private String nickName;
    private String position;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL, using = JsonURLDateSerializer.class)
    private String wxqrCode;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL, using = JsonURLDateSerializer.class)
    private String maxPoster;
    private Integer isMember;
}
