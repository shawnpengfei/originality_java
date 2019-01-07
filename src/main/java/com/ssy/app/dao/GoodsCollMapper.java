package com.ssy.app.dao;

import com.ssy.app.enity.GoodsColl;

public interface GoodsCollMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsColl record);

    int insertSelective(GoodsColl record);

    GoodsColl selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsColl record);

    int updateByPrimaryKey(GoodsColl record);
}