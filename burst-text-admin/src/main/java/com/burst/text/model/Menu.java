package com.burst.text.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Menu implements Serializable {
    private String menuId;
    private String menuName;
    private String menuType;
    private String menuUrl;
    private String menuCode;
    private String parentId;

    private List<Menu> children;
}
