package com.ssy.app.service;

import com.ssy.app.enity.Goods;
import com.ssy.app.vo.PageBeanVo;

import java.util.List;
import java.util.Map;

public interface GoodsService {

    public PageBeanVo<Goods> showGoodsByCid(Long typeid, Integer page, Integer limit );



}
