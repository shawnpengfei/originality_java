package com.ssy.app.service;

import com.ssy.app.enity.Subjectclass;
import com.ssy.app.vo.PageBeanVo;
import com.ssy.app.vo.ResultVo;

import java.util.List;

public interface SubjectService {

    //查询所有专题分类
    ResultVo selectAll();

    //查询所有专题分类详情
    PageBeanVo<Subjectclass> queryPage(int page, int limit);

    //根据ID查询专题详 s 情
    ResultVo selectById(int id);
}
