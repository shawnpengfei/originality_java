package com.ssy.app.dao;

import com.ssy.app.enity.GoodsOrderDesc;

public interface GoodsOrderDescMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsOrderDesc record);

    int insertSelective(GoodsOrderDesc record);

    GoodsOrderDesc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsOrderDesc record);

    int updateByPrimaryKey(GoodsOrderDesc record);
}