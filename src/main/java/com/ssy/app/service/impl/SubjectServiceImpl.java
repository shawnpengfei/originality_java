package com.ssy.app.service.impl;

import com.ssy.app.dao.SubjectMapper;
import com.ssy.app.dao.SubjectclassMapper;
import com.ssy.app.enity.Subjectclass;
import com.ssy.app.service.SubjectService;
import com.ssy.app.vo.PageBeanVo;
import com.ssy.app.vo.ResultVo;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectDao;
    @Autowired
    private SubjectclassMapper subjectclassDao;

    //查询所有专题分类
    @Override
    public ResultVo selectAll() {
        return ResultVo.setOK(subjectDao.selectAll());
    }

    //查询所有专题分类详情
    @Override
    public PageBeanVo<Subjectclass> queryPage(int page, int limit) {
        Map<String, Object> map = new HashedMap();
        map.put("index", (page-1)*limit);
        map.put("limit", limit);
        return PageBeanVo.setPage(subjectclassDao.selectCount(), subjectclassDao.selectByPage(map));
    }

    //根据ID查询专题详情
    @Override
    public ResultVo selectById(int id) {
        ResultVo rv = new ResultVo();
        Subjectclass sc = subjectclassDao.selectByPrimaryKey(id);
        rv.setCode(0);
        rv.setData(sc);
        return rv;
    }
}
