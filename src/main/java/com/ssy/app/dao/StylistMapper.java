package com.ssy.app.dao;

import com.ssy.app.enity.Stylist;
import com.ssy.app.vo.StyVo;

import java.util.List;
import java.util.Map;

public interface StylistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Stylist record);

    int insertSelective(Stylist record);

    Stylist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stylist record);

    int updateByPrimaryKey(Stylist record);

    //连表查询设计师信息
    List<StyVo> selectByPage(Map<String,Object> map);

    //查询数量
    int selectCount();

    //根据城市查询设计师
    List<StyVo> selectByCity(String city);

    //根据ID查询设计师
    List<StyVo> selectBycid(int cid);

    //根据ID查询地址
    StyVo selectAddr(int id);

}