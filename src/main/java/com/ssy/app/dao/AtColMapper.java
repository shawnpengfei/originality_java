package com.ssy.app.dao;

import com.ssy.app.enity.AtCol;

public interface AtColMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AtCol record);

    int insertSelective(AtCol record);

    AtCol selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AtCol record);

    int updateByPrimaryKey(AtCol record);
}