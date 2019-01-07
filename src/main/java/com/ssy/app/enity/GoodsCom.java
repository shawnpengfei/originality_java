package com.ssy.app.enity;

public class GoodsCom {
    private Long id;

    private Long oderDescId;

    private String descr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOderDescId() {
        return oderDescId;
    }

    public void setOderDescId(Long oderDescId) {
        this.oderDescId = oderDescId;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }
}