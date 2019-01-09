package com.ssy.app.dao;

import com.ssy.app.enity.Subject;

import java.util.List;

public interface SubjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);

    //查询所有专题分类
    List<Subject> selectAll();
}