package com.daejong.enums;

import lombok.Getter;

/**
 * Created by Daejong on 2017/10/14.
 */
@Getter
public enum ResultEnum {
    SUCCESS(200, "success"),
    ERROR(400, "error")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
