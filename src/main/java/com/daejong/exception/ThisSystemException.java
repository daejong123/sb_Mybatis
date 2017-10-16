package com.daejong.exception;

import com.daejong.enums.ResultEnum;

/**
 * 系统异常统一处理点.
 * Created by Daejong on 2017/10/16.
 */
public class ThisSystemException extends RuntimeException {

    private Integer code;

    public ThisSystemException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public ThisSystemException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
