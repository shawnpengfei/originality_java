package com.ssy.app.dao;

import com.ssy.app.enity.Stycity;

public interface StycityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Stycity record);

    int insertSelective(Stycity record);

    Stycity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stycity record);

    int updateByPrimaryKey(Stycity record);
}