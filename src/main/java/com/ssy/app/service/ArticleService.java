package com.ssy.app.service;

import com.ssy.app.enity.ArticleClassify;
import com.ssy.app.vo.ArticleDes;
import com.ssy.app.vo.ArticlePageVo;

import java.util.List;

public interface ArticleService {
    List<ArticleClassify> findAllClassfiy();

    ArticlePageVo getArticleByPage(int pageNum,int pageSize,Integer classifyId);

    boolean articleLike(Long id);

    boolean articleCollection(long uid,long atId);

    ArticleDes getArticle(Long id);
}
