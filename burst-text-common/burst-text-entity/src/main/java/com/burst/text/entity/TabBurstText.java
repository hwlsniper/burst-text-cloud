package com.burst.text.entity;

import java.util.Date;

public class TabBurstText {
    private String id;

    private String title;

    private String userId;

    private String shortTitle;

    private String titleImg;

    private String content;

    private String burstSource;

    private String burstType;

    private String burstAscripte;

    private Integer browseNum;

    private Integer shareNum;

    private Integer isTop;

    private Integer isEnable;

    private Date createdDate;

    private Date updatedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle == null ? null : shortTitle.trim();
    }

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg == null ? null : titleImg.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getBurstSource() {
        return burstSource;
    }

    public void setBurstSource(String burstSource) {
        this.burstSource = burstSource == null ? null : burstSource.trim();
    }

    public String getBurstType() {
        return burstType;
    }

    public void setBurstType(String burstType) {
        this.burstType = burstType == null ? null : burstType.trim();
    }

    public String getBurstAscripte() {
        return burstAscripte;
    }

    public void setBurstAscripte(String burstAscripte) {
        this.burstAscripte = burstAscripte == null ? null : burstAscripte.trim();
    }

    public Integer getBrowseNum() {
        return browseNum;
    }

    public void setBrowseNum(Integer browseNum) {
        this.browseNum = browseNum;
    }

    public Integer getShareNum() {
        return shareNum;
    }

    public void setShareNum(Integer shareNum) {
        this.shareNum = shareNum;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}