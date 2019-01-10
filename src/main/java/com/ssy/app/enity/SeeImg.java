package com.ssy.app.enity;

public class SeeImg {
    private Long id;

    private Long cid;

    private Long uid;

    private Long starsNum;

    private String imgurl;

    private String descr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getStarsNum() {
        return starsNum;
    }

    public void setStarsNum(Long starsNum) {
        this.starsNum = starsNum;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}