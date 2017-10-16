package com.daejong.utils;

import com.daejong.enums.ResultEnum;
import com.daejong.vo.ResultVO;

/**
 * Created by Daejong on 2017/10/14.
 */
public class ResultVoUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMsg(ResultEnum.SUCCESS.getMsg());
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.ERROR.getCode());
        resultVO.setMsg(ResultEnum.ERROR.getMsg());
        return resultVO;
    }
}
