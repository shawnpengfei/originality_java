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

    //展示所有
    List<Subjectclass> selectByPage(Map<String,Object> param);

    //查询数量
    int selectCount();

    //根据jid查询专题列表
    List<Subjectclass> selectByjid(int jid);
}