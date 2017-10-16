package com.daejong.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Daejong on 2017/10/14.
 */
@Data
public class HouseEntity {

    private String houseId;

    private String houseName;

    private String houseLocation;

    private BigDecimal price;

    private String url;

    private String comment;
}
