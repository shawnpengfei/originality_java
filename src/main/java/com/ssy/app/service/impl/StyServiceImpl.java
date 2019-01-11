package com.ssy.app.service.impl;

import com.ssy.app.dao.StycityMapper;
import com.ssy.app.dao.StylistMapper;
import com.ssy.app.enity.Stylist;
import com.ssy.app.service.StyService;
import com.ssy.app.vo.AreaVo;
import com.ssy.app.vo.PageBeanVo;
import com.ssy.app.vo.ResultVo;
import com.ssy.app.vo.StyVo;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StyServiceImpl implements StyService {

    @Autowired
    private StylistMapper stylistDao;

    @Autowired
    private StycityMapper stycityDao;

    @Override
    public PageBeanVo<StyVo> queryPage(int page, int limit) {
        Map<String, Object> map = new HashedMap();
        map.put("index", (page-1)*limit);
        map.put("limit", limit);
        return PageBeanVo.setPage(stylistDao.selectCount(), stylistDao.selectByPage(map));
    }

    //根据城市名字查询设计师
    @Override
    public ResultVo selectByCity(String name) {
        List<StyVo> styVo = stylistDao.selectByCity(name);
        if (styVo!=null){
            return ResultVo.setOK(styVo);
        }else {
            return ResultVo.setERROR();
        }
    }

    //根据城市ID查询设计师
    @Override
    public ResultVo selectBycid(int id) {
        List<StyVo> styVo = stylistDao.selectBycid(id);
        if (styVo!=null){
            return ResultVo.setOK(styVo);
        }else {
            return ResultVo.setERROR();
        }
    }

    //根据ID查询设计师信息
    @Override
    public ResultVo selectById(int id) {
        Stylist stylist = stylistDao.selectByPrimaryKey(id);
        if (stylist!=null){
            return ResultVo.setOK(stylist);
        }else {
            return ResultVo.setERROR();
        }
    }

    //添加设计师
    @Override
    public ResultVo addSty(Stylist stylist) {
        if (stylistDao.insert(stylist)>0){
            return ResultVo.setOK(null);
        }else {
            return ResultVo.setERROR();
        }
    }

    //根据ID查询地址
    @Override
    public ResultVo selectAddr(int id) {
        StyVo styVo = stylistDao.selectAddr(id);
        if (styVo!=null){
            return ResultVo.setOK(styVo);
        }else {
            return ResultVo.setERROR();
        }
    }

    //查询地区列表
    @Override
    public ResultVo selectAll() {
        List<AreaVo> areaVo = stycityDao.selectAll();
        if (areaVo!=null){
            return ResultVo.setOK(areaVo);
        }else{
            return ResultVo.setERROR();
        }
    }

}
