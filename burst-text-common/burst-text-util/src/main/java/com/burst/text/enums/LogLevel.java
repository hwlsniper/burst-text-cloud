package com.burst.text.enums;

/**
 * @ClassName: LogLevel
 * @Description:日志等级
 * @author: 天刀-盛泽荣
 * @date: 2018年6月12日 下午9:55:26
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved.
 * 注意：本内容仅限于***内部传阅，禁止外泄以及用于其他的商业目
 */
public enum LogLevel {
    LOG_LEVEL_NORMAL("1001", "操作正常"),
    LOG_LEVEL_EXCEPTE("2001", "错误"),
    LOG_LEVEL_ERROR("3001", "未知错误");

    private String levelCode;
    private String levelMsg;

    private LogLevel(String levelCode, String levelMsg) {
        this.levelCode = levelCode;
        this.levelMsg = levelMsg;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getLevelMsg() {
        return levelMsg;
    }

    public void setLevelMsg(String levelMsg) {
        this.levelMsg = levelMsg;
    }
}
