package com.ssy.app.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssy.app.dao.*;
import com.ssy.app.enity.*;
import com.ssy.app.service.ArticleService;
import com.ssy.app.utils.YhzUtils;
import com.ssy.app.vo.ArticleDes;
import com.ssy.app.vo.ArticlePageVo;
import com.ssy.app.vo.ArticleVo;
import com.ssy.app.vo.GoodsInArticleVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

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
    @Autowired
    private AtColMapper atColMapper;
    @Override
    public List<ArticleClassify> findAllClassfiy() {
        return articleClassifyMapper.selectAll();
    }

    @Override
    public ArticlePageVo getArticleByPage(int pageNum, int pageSize,Integer classifyId) {
        ArticlePageVo articlePageVo = new ArticlePageVo();

        Page<Article> page = PageHelper.startPage(pageNum, pageSize);
        List<Article> list = articleMapper.selectAll(classifyId);

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
            articleVo.setIntroduction(article.getIntroduction());
            long count = artCommentMapper.selectCountByUid(uid);
            articleVo.setComments(count);
            Goods goods = goodsMapper.selectByPrimaryKey(article.getGoodsId());
            GoodsInArticleVo goodsInArticleVo = new GoodsInArticleVo();
            goodsInArticleVo.setId(goods.getId());
            goodsInArticleVo.setGoodsName(goods.getName());
            goodsInArticleVo.setImgurl(goods.getImg());
            goodsInArticleVo.setPrice(goods.getPrice());
            articleVo.setGoodsInArticleVo(goodsInArticleVo);
            articlePageVo.getList().add(articleVo);
        }
        return articlePageVo;
    }

    @Override
    public boolean articleLike(Long id) {
        return articleMapper.updateLike(id)>0;
    }

    @Override
    public boolean articleCollection(long uid, long atId) {
        AtCol atCol = new AtCol();
        atCol.setAtId(atId);
        atCol.setUid(uid);
        return atColMapper.insertSelective(atCol)>0;
    }

    @Override
    public ArticleDes getArticle(Long id) {

        return null;
    }


}
