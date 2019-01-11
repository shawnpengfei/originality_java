package com.ssy.app.controller;

import com.ssy.app.service.ArticleService;
import com.ssy.app.vo.ArticleClassifyVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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


}
