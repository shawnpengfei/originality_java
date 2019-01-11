package com.ssy.app.vo;

import com.ssy.app.enity.ArticleClassify;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "种草分类",description = "种草分类")
public class ArticleClassifyVo {
    @ApiModelProperty(name = "list",value = "种草分类数组")
    private List<ArticleClassify> list;

    public List<ArticleClassify> getList() {
        return list;
    }

    public void setList(List<ArticleClassify> list) {
        this.list = list;
    }
}
