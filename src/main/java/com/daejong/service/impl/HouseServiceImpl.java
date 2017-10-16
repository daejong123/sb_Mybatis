package com.daejong.service.impl;

import com.daejong.entity.HouseEntity;
import com.daejong.mapper.HouseMapper;
import com.daejong.service.HouseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Daejong on 2017/10/15.
 */
@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseMapper houseMapper;

    @Override
    public List<HouseEntity> findAll() {
        return houseMapper.getAll();
    }

    @Override
    public List<HouseEntity> findLessThanPrice(BigDecimal housePrice) {
        return houseMapper.findLowerPrice(housePrice);
    }
}
