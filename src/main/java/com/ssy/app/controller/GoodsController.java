package com.ssy.app.controller;


import com.ssy.app.service.GoodsService;
import com.ssy.app.vo.PageBeanVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
@Api(produces = "商品接口",tags = "商品",value = "Goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;
    @GetMapping("/showGoodsByclass")
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

//    public PageBeanVo<> showAllGoodsType(){
//
//    }


}
