package com.ssy.app.service;

import com.ssy.app.vo.PageBeanVo;
import com.ssy.app.vo.ResultVo;
import com.ssy.app.vo.TopicVo;

public interface TopicService {
    //分页查询话题
    PageBeanVo<TopicVo> queryPage(int page,int limit);

    //根据话题分类ID查询话题
    ResultVo selectBycid(int id);

    ResultVo selectById(int id);
}
