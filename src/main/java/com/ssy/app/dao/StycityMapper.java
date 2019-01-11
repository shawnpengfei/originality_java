package com.ssy.app.dao;

import com.ssy.app.enity.Stycity;
import com.ssy.app.vo.AreaVo;

import java.util.List;

public interface StycityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Stycity record);

    int insertSelective(Stycity record);

    Stycity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stycity record);

    int updateByPrimaryKey(Stycity record);

    //查询地区列表
    List<AreaVo> selectAll();
}