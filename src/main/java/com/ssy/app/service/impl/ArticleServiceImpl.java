package com.ssy.app.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssy.app.dao.*;
import com.ssy.app.enity.Article;
import com.ssy.app.enity.ArticleClassify;
import com.ssy.app.enity.Goods;
import com.ssy.app.enity.UserInfo;
import com.ssy.app.service.ArticleService;
import com.ssy.app.utils.YhzUtils;
import com.ssy.app.vo.ArticlePageVo;
import com.ssy.app.vo.ArticleVo;
import com.ssy.app.vo.GoodsInArticleVo;
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
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private ArtCommentMapper artCommentMapper;
    @Autowired
    private GoodsMapper goodsMapper;

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
            ArticleVo articleVo = new ArticleVo();
            articleVo.setId(article.getId());
            long uid = article.getUid();
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(uid);
            articleVo.setNickName(userInfo.getNickname());
            articleVo.setTimeAgo(YhzUtils.getTime(article.getCreattime()));
            articleVo.setImgurl(article.getImgurl());
            articleVo.setLikes(article.getLikeNum());
            articleVo.setStarts(article.getStarsNum());
            long count = artCommentMapper.selectCountByUid(uid);
            articleVo.setComments(count);
            Goods goods = goodsMapper.selectByPrimaryKey(article.getGoodsId());
            GoodsInArticleVo goodsInArticleVo = new GoodsInArticleVo();
            goodsInArticleVo.setId(goods.getId());
            goodsInArticleVo.setGoodsName(goods.getName());
            goodsInArticleVo.setImgurl("http://47.107.64.250:8080/imgsss/1.jpg");
            goodsInArticleVo.setPrice(goods.getPrice());
            articleVo.setGoodsInArticleVo(goodsInArticleVo);
            articlePageVo.getList().add(articleVo);
        }
        return articlePageVo;
    }
}
