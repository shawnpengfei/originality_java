package com.ssy.app.dao;

import com.ssy.app.enity.SeeImgClassify;

public interface SeeImgClassifyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SeeImgClassify record);

    int insertSelective(SeeImgClassify record);

    SeeImgClassify selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeeImgClassify record);

    int updateByPrimaryKey(SeeImgClassify record);
}