package com.ssy.app.enity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "种草分类实体",description = "包括id和分类")
public class ArticleClassify {
    @ApiModelProperty(value = "id",name = "id")
    private Integer id;
    @ApiModelProperty(value = "分类",name = "classify")
    private String classify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }
}