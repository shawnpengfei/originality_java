package com.ssy.app.dao;

import com.ssy.app.enity.Adress;

public interface AdressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Adress record);

    int insertSelective(Adress record);

    Adress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Adress record);

    int updateByPrimaryKey(Adress record);
}