package com.ssy.app.dao;

import com.ssy.app.enity.SeeImg;
import com.ssy.app.vo.PageBeanVo;

import java.util.List;

public interface SeeImgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SeeImg record);

    int insertSelective(SeeImg record);

    SeeImg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeeImg record);

    int updateByPrimaryKey(SeeImg record);

    List<SeeImg> showImgAll(Integer page, Integer count);

    List <SeeImg> showSeeImgByclass(Long cid, Integer page, Integer count);

    int startImg(Integer imgId);
}