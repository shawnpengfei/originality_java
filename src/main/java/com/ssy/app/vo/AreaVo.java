package com.ssy.app.vo;

import com.ssy.app.enity.Styregion;

import java.util.List;

public class AreaVo {
    private int id;

    private String name;

    private List<Styregion> regionList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Styregion> getRegionList() {
        return regionList;
    }

    public void setRegionList(List<Styregion> regionList) {
        this.regionList = regionList;
    }
}
