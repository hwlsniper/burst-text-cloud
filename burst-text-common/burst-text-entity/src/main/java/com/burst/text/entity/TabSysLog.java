package com.burst.text.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统日志
 *
 * @author Administrator
 */
@Data
public class TabSysLog implements Serializable {
    private String id;

    private String userId;

    private String node;

    private String operate;

    private String logContent;

    private String method;

    private String logLevel;

    private String param;

    private String logSource;

    private Date createdDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node == null ? null : node.trim();
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate == null ? null : operate.trim();
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel == null ? null : logLevel.trim();
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }

    public String getLogSource() {
        return logSource;
    }

    public void setLogSource(String logSource) {
        this.logSource = logSource == null ? null : logSource.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "TabSysLog{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", node='" + node + '\'' +
                ", operate='" + operate + '\'' +
                ", logContent='" + logContent + '\'' +
                ", method='" + method + '\'' +
                ", logLevel='" + logLevel + '\'' +
                ", param='" + param + '\'' +
                ", logSource='" + logSource + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}