package com.ssy.app.service;


import com.ssy.app.enity.SeeImg;
import com.ssy.app.vo.JsonBean;

public interface SeeImgService {

    JsonBean deleteSeenImgById(Long id);

    JsonBean addSeeImg(SeeImg seeImg);

    JsonBean addSeeImgSelective(SeeImg record);

    JsonBean selectSeeImgById(Long id);

    JsonBean updateByIdSelective(SeeImg record);

    JsonBean updateById(SeeImg record);


}
