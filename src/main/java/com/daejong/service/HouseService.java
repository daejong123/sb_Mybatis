package com.daejong.service;

import com.daejong.entity.HouseEntity;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Daejong on 2017/10/15.
 */
public interface HouseService {

    public List<HouseEntity> findAll();

    public List<HouseEntity> findLessThanPrice(BigDecimal housePrice);
}
