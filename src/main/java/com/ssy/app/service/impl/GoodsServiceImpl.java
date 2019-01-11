package com.ssy.app.service.impl;

import com.ssy.app.dao.GoodsMapper;
import com.ssy.app.enity.Goods;
import com.ssy.app.service.GoodsService;
import com.ssy.app.vo.JsonBean;
import com.ssy.app.vo.PageBeanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    GoodsMapper Gdao;

    @Override
    public PageBeanVo<Goods> showGoodsByCid(Long typeid, Integer page, Integer limit ) {

        PageBeanVo vo = new PageBeanVo();
        Map<String,Object> map = new HashMap<>();
        map.put("typeid",typeid);
        map.put("index",(page - 1) * limit);
        map.put("limit",limit);
        try {
            List<Goods> list = Gdao.showGoodsByCid(map);
            vo.setCode(0);
            vo.setMsg("查询成功");
            vo.setCount(list.size());
            vo.setData(list);
        }catch (Exception e){
            e.printStackTrace();
            vo.setCode(-1);
            vo.setMsg("暂无数据");
        }
        return vo;
    }

    @Override
    public JsonBean selectGoodsById(Long id) {

        JsonBean bean = new JsonBean();
        Goods goods = Gdao.selectByPrimaryKey(id);
        bean.setCode(0);
        bean.setInfo(goods);
        return bean;
    }
}
