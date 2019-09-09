package com.burst.text.excepte;

import com.burst.text.util.Result;

public class BizException extends RuntimeException {
    /**
     * 异常的状态码
     **/
    private Integer code;

    /**
     * 异常的状态描述
     **/
    private String message;

    public BizException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result returnResult() {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(message);
        return result;
    }
}
