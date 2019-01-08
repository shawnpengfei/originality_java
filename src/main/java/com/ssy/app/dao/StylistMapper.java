package com.ssy.app.dao;

import com.ssy.app.enity.Stylist;

public interface StylistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Stylist record);

    int insertSelective(Stylist record);

    Stylist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stylist record);

    int updateByPrimaryKey(Stylist record);
}