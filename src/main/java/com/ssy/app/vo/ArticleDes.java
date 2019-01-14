package com.ssy.app.vo;

import com.ssy.app.enity.ArtComment;
import com.ssy.app.enity.Goods;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class ArticleDes {
    @ApiModelProperty(value = "文章id",name = "id")
    private Long id;
    @ApiModelProperty(value = "文章拥有着id",name = "uid")
    private Long uid;
    @ApiModelProperty(value = "昵称",name = "nickName")
    private String nickName;
    @ApiModelProperty(value = "文章内容",name = "descr")
    private String descr;
    @ApiModelProperty(value = "图片url",name = "imgurl")
    private String imgurl;
    @ApiModelProperty(value = "商品",name = "goods")
    private Goods goods;
    private List<ArtComment> commentList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<ArtComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<ArtComment> commentList) {
        this.commentList = commentList;
    }
}
