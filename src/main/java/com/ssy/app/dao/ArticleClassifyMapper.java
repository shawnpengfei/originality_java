package com.ssy.app.dao;

import com.ssy.app.enity.ArticleClassify;

import java.util.List;

public interface ArticleClassifyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleClassify record);

    int insertSelective(ArticleClassify record);

    ArticleClassify selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleClassify record);

    int updateByPrimaryKey(ArticleClassify record);

    List<ArticleClassify> selectAll();
}