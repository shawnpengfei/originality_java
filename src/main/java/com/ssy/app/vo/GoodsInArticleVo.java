package com.ssy.app.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "种草中商品信息",description = "商品信息")
public class GoodsInArticleVo {

    @ApiModelProperty(name = "id",value = "商品id")
    private long id;
    @ApiModelProperty(name = "goodsName",value = "商品名")
    private String goodsName;
    @ApiModelProperty(name = "imgurl",value = "图片url")
    private String imgurl;
    @ApiModelProperty(name = "price",value = "商品价格")
    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
