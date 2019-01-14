package com.ssy.app.controller;


import com.ssy.app.enity.GoodsType;
import com.ssy.app.service.GoodsService;
import com.ssy.app.service.GoodsTypeService;
import com.ssy.app.vo.JsonBean;
import com.ssy.app.vo.PageBeanVo;
import com.ssy.app.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goods")
@Api(produces = "商品接口",tags = "商品",value = "Goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;
    @Autowired
    GoodsTypeService gtpService;


    @GetMapping("/showGoodsByType")
    @CrossOrigin
    //根据传来的商品种类id展示商品
    public PageBeanVo showGoods(Long typeid, Integer page, Integer limit ){

        PageBeanVo vo = new PageBeanVo();
        if(typeid != null && !typeid.equals("") &&  page != null && page != 0 && !page.equals("") &&  limit != null && !limit.equals("")){
            vo = goodsService.showGoodsByCid(typeid,page,limit);
            return vo;
        } else{
            vo.setCode(-1);
            vo.setMsg("传入参数不合法");
            return vo;
        }

    }

    @GetMapping("/showFatherGoodsType")
    @CrossOrigin
    //在前端页面展示商品大类的方法，返回商品类型的所有信息
    public ResultVo showFatherGoodsType(){

        return gtpService.showFatherGoodsType();

    }

    @GetMapping("/selectGoodsById")
    @CrossOrigin
    public JsonBean selectGoodsById(long id){
        JsonBean bean = new JsonBean();
        if(id > 0 ){
            return goodsService.selectGoodsById(id);
        }
        else {
            bean.setCode(-1);
            bean.setInfo("传入参数非法");
            return bean;
        }
    }

}
