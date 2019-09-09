package com.burst.text.enums;

public enum ResultCode {
    SUCCESS_OPERATE("操作成功!", 200),
    FAIL_OPERATE("操作失败!", 400),
    RE_LOGGED_IN("重新登录!", 406),
    MEMBER_USED("会员才可以操作!", 500),
    PURCHASE_USED("购买后可以操作!", 501);

    private String msg;
    private int code;

    private ResultCode(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
