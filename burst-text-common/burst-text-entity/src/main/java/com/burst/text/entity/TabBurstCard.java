package com.burst.text.entity;

import java.util.Date;

public class TabBurstCard {
    private String id;

    private String burstId;

    private String cardUpId;

    private String cardFootId;

    private Date createdDate;

    private Date updatedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBurstId() {
        return burstId;
    }

    public void setBurstId(String burstId) {
        this.burstId = burstId == null ? null : burstId.trim();
    }

    public String getCardUpId() {
        return cardUpId;
    }

    public void setCardUpId(String cardUpId) {
        this.cardUpId = cardUpId == null ? null : cardUpId.trim();
    }

    public String getCardFootId() {
        return cardFootId;
    }

    public void setCardFootId(String cardFootId) {
        this.cardFootId = cardFootId == null ? null : cardFootId.trim();
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