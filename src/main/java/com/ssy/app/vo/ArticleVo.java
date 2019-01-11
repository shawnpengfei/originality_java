package com.ssy.app.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "种草简介",description = "种草简介")
public class ArticleVo {
    @ApiModelProperty(name = "id",value = "种草id")
    private int id;
    @ApiModelProperty(name = "nickName",value = "种草用户昵称")
    private String nickName;
    @ApiModelProperty(name = "timeAgo",value = "发布时间")
    private String timeAgo;
    @ApiModelProperty(name = "introduction",value = "种草简介/标题")
    private String introduction;
    @ApiModelProperty(name = "imgurl",value = "种草图片")
    private String imgurl;
    @ApiModelProperty(name = "starts",value = "收藏数")
    private int starts;
    @ApiModelProperty(name = "likes",value = "点赞数")
    private int likes;
    @ApiModelProperty(name = "comments",value = "评论数")
    private int comments;
    @ApiModelProperty(name = "goodsInArticleVo",value = "商品信息")
    private GoodsInArticleVo goodsInArticleVo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTimeAgo() {
        return timeAgo;
    }

    public void setTimeAgo(String timeAgo) {
        this.timeAgo = timeAgo;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public int getStarts() {
        return starts;
    }

    public void setStarts(int starts) {
        this.starts = starts;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public GoodsInArticleVo getGoodsInArticleVo() {
        return goodsInArticleVo;
    }

    public void setGoodsInArticleVo(GoodsInArticleVo goodsInArticleVo) {
        this.goodsInArticleVo = goodsInArticleVo;
    }
}
