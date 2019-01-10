package com.ssy.app.dao;

import com.ssy.app.enity.SeeImg;
import com.ssy.app.enity.SeeImgCollection;
import org.jboss.logging.Param;

import java.util.List;
import java.util.Map;

public interface SeeImgCollectionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SeeImgCollection record);

    int insertSelective(SeeImgCollection record);

    SeeImgCollection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeeImgCollection record);

    int updateByPrimaryKey(SeeImgCollection record);

    int insertCollection(Map<String,Object> param);

   // List<SeeImg> showMystarImg(Long uid,Integer page,Integer count);

}