package com.ssy.app.dao;

import com.ssy.app.enity.SeeImgCollection;

public interface SeeImgCollectionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SeeImgCollection record);

    int insertSelective(SeeImgCollection record);

    SeeImgCollection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeeImgCollection record);

    int updateByPrimaryKey(SeeImgCollection record);
}