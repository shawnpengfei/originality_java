package com.ssy.app.service;

import com.ssy.app.enity.Goods;
import com.ssy.app.vo.JsonBean;
import com.ssy.app.vo.PageBeanVo;

import java.util.List;
import java.util.Map;

public interface GoodsService {

    PageBeanVo<Goods> showGoodsByCid(Long typeid, Integer page, Integer limit );

    JsonBean  selectGoodsById(Long id);

}
