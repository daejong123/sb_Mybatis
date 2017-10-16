package com.daejong.vo;

import lombok.Data;

/**
 * Created by Daejong on 2017/10/14.
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
