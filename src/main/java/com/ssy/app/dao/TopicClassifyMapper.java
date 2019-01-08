package com.ssy.app.dao;

import com.ssy.app.enity.TopicClassify;

public interface TopicClassifyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TopicClassify record);

    int insertSelective(TopicClassify record);

    TopicClassify selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TopicClassify record);

    int updateByPrimaryKey(TopicClassify record);
}