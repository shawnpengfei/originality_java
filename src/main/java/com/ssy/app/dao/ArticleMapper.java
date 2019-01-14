package com.ssy.app.dao;

import com.ssy.app.enity.Article;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> selectAll(Integer classifyId);

    int updateLike(Long id);
}