package com.ssy.app.dao;

import com.ssy.app.enity.Subjectclass;

import java.util.List;
import java.util.Map;

public interface SubjectclassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Subjectclass record);

    int insertSelective(Subjectclass record);

    Subjectclass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Subjectclass record);

    int updateByPrimaryKey(Subjectclass record);

    //分页查询专题分类
    List<Subjectclass> selectByPage(Map<String, Object> param);

    //查询数量
    int selectCount();
}