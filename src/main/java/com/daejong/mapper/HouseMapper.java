package com.daejong.mapper;

import com.daejong.entity.HouseEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Daejong on 2017/10/14.
 */
@Component
public interface HouseMapper {


    @Select("select * from tb_house")
    @ResultMap("houseMap")
    public List<HouseEntity> getAll();

    @Select("select * from tb_house where price<#{housePrice}")
    @Results({
            @Result(property = "houseId", column = "id"),
            @Result(property = "houseName", column = "name"),
            @Result(property = "houseLocation", column = "location")
    })
    public List<HouseEntity> findLowerPrice(@Param("housePrice") BigDecimal housePrice);
}
