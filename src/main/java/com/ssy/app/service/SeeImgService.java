package com.ssy.app.service;


import com.ssy.app.enity.SeeImg;
import com.ssy.app.vo.JsonBean;
import com.ssy.app.vo.PageBeanVo;

public interface SeeImgService {

    JsonBean deleteSeenImgById(Long id);

    JsonBean addSeeImg(SeeImg seeImg);

    JsonBean addSeeImgSelective(SeeImg record);

    //根据查看图片
    JsonBean selectSeeImgById(Long id);

    JsonBean updateByIdSelective(SeeImg record);

    JsonBean updateById(SeeImg record);

    PageBeanVo showImgAll(Integer page, Integer count);

    PageBeanVo showSeeImgByClass(Integer cid, Integer page, Integer count);

    JsonBean starImg(Integer star);
}
