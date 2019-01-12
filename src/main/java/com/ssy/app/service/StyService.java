package com.ssy.app.service;

import com.ssy.app.enity.Stylist;
import com.ssy.app.vo.PageBeanVo;
import com.ssy.app.vo.ResultVo;
import com.ssy.app.vo.StyVo;

public interface StyService {

    //分页查询
    PageBeanVo<StyVo> queryPage(int page, int limit);

    //根据城市名字查询设计师
    ResultVo selectByCity(String name);

    //根据城市ID查询设计师
    ResultVo selectBycid(int id);

    //根据ID查询设计师信息
    ResultVo selectById(int id);

    //添加设计师
    ResultVo addSty(Stylist stylist);

    //根据ID查询地址
    ResultVo selectAddr(int id);

    //查询地区列表
    ResultVo selectAll();

}
