package com.ssy.app.dao;

import com.ssy.app.enity.TopicDiscuss;
import com.ssy.app.vo.TopicVo;

public interface TopicDiscussMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TopicDiscuss record);

    int insertSelective(TopicDiscuss record);

    TopicDiscuss selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TopicDiscuss record);

    int updateByPrimaryKey(TopicDiscuss record);

    //根据ID查询话题
    TopicVo selectById(int id);
}