package com.ssy.app.dao;

import com.ssy.app.enity.Topic;
import com.ssy.app.vo.TopicVo;

import java.util.List;
import java.util.Map;

public interface TopicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKey(Topic record);

    //分页查询所有话题
    List<TopicVo> selectByPage(Map<String,Object> map);

    //查询数量
    int selectCount();

    //根据分类ID查询话题
    List<TopicVo> selectBycid(int id);
}