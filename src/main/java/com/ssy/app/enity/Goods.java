package com.ssy.app.enity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "商品",description = "商品信息")
public class Goods {
    @ApiModelProperty(value = "商品id",name = "id")
    private Long id;
    @ApiModelProperty(value = "商品名字",name = "name")
    private String name;
    @ApiModelProperty(value = "商品价格",name = "price")
    private Double price;
    @ApiModelProperty(value = "商品类型id",name = "typeid")
    private Long typeid;
    @ApiModelProperty(value = "商品描述",name = "descr")
    private String descr;
    @ApiModelProperty(value = "商品数量",name = "商品id")
    private Long num;
    @ApiModelProperty(value = "商品图片",name = "img")
    private String img;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}