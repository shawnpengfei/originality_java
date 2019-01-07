package com.ssy.app.dao;

import com.ssy.app.enity.GoodsCom;

public interface GoodsComMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsCom record);

    int insertSelective(GoodsCom record);

    GoodsCom selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsCom record);

    int updateByPrimaryKey(GoodsCom record);
}