package com.ssy.app.service.impl;

import com.ssy.app.dao.GoodsTypeMapper;
import com.ssy.app.enity.GoodsType;
import com.ssy.app.service.GoodsTypeService;
import com.ssy.app.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    GoodsTypeMapper gtyDao;
    @Override
    public ResultVo showFatherGoodsType() {

        ResultVo vo = new ResultVo();
        List<GoodsType> list = gtyDao.showFatherGoodsType();

        vo.setCode(0);
        vo.setData(list);
        vo.setMsg("OK");
        return vo;
    }

}
