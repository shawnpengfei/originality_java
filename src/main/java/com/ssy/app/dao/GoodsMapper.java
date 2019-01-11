package com.ssy.app.dao;

import com.ssy.app.enity.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> showGoodsByCid(Map<String,Object> param);
}