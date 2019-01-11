package com.ssy.app.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
@ApiModel(value = "“种草”页展示",description = "展示“种草”的简介")
public class ArticlePageVo {
    @ApiModelProperty(name = "totals",value = "数据总数")
    private long totals;
    @ApiModelProperty(name = "每页种草的列表",value = "list")
    private List<ArticleVo> list;

    public long getTotals() {
        return totals;
    }

    public void setTotals(long totals) {
        this.totals = totals;
    }

    public List<ArticleVo> getList() {
        return list;
    }

    public void setList(List<ArticleVo> list) {
        this.list = list;
    }
}
