package com.ssy.app.controller;

import com.ssy.app.service.ArticleService;
import com.ssy.app.vo.ArticleClassifyVo;
import com.ssy.app.vo.ArticlePageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
@Api(value = "种草页面接口",tags = "种草",produces = "种草页面接口")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/classify")
    @ApiOperation(notes = "获取所有分类",value = "获取所有分类")
    public ArticleClassifyVo getAllClassify(){
        ArticleClassifyVo articleClassifyVo  = new ArticleClassifyVo();
        articleClassifyVo.setList(articleService.findAllClassfiy());
        return articleClassifyVo;
    }

    @GetMapping("/articleList")
    @ApiOperation(value = "根据种草分类分页获取种草简介",notes = "根据中操分类获取种草页面的简介列表")
    public ArticlePageVo getArticleByClassify(
            @ApiParam(name = "pageNum",value = "分页页码") int pageNum,
            @ApiParam(name = "pageSize",value = "分页种草的数量") int pageSize,
            @ApiParam(name = "classifyId",value = "种草的分类id") Integer classifyId){
        return articleService.getArticleByPage(pageNum, pageSize, classifyId);
    }

}
