package com.ssy.app.dao;

import com.ssy.app.enity.GoodsType;

import java.util.List;

public interface GoodsTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);

    List<GoodsType> showFatherGoodsType();
}