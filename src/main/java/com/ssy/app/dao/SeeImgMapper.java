package com.ssy.app.dao;

import com.ssy.app.enity.SeeImg;

public interface SeeImgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SeeImg record);

    int insertSelective(SeeImg record);

    SeeImg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeeImg record);

    int updateByPrimaryKey(SeeImg record);
}