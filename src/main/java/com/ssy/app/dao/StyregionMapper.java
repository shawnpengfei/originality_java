package com.ssy.app.dao;

import com.ssy.app.enity.Styregion;

public interface StyregionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Styregion record);

    int insertSelective(Styregion record);

    Styregion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Styregion record);

    int updateByPrimaryKey(Styregion record);
}