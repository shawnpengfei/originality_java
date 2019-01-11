package com.ssy.app.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssy.app.dao.ArticleClassifyMapper;
import com.ssy.app.dao.ArticleMapper;
import com.ssy.app.enity.Article;
import com.ssy.app.enity.ArticleClassify;
import com.ssy.app.service.ArticleService;
import com.ssy.app.vo.ArticlePageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleClassifyMapper articleClassifyMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public List<ArticleClassify> findAllClassfiy() {
        return articleClassifyMapper.selectAll();
    }

    @Override
    public ArticlePageVo getArticleByPage(int pageNum, int pageSize) {
        ArticlePageVo articlePageVo = new ArticlePageVo();

        Page<Article> page = PageHelper.startPage(pageNum, pageSize);
        List<Article> list = articleMapper.selectAll();

        articlePageVo.setTotals(page.getTotal());
        articlePageVo.setList(new ArrayList<>());
        for (Article article: list) {

        }

        return null;
    }
}
