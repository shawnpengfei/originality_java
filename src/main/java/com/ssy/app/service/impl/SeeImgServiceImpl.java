package com.ssy.app.service.impl;

import com.ssy.app.dao.SeeImgMapper;
import com.ssy.app.enity.SeeImg;
import com.ssy.app.service.SeeImgService;
import com.ssy.app.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeeImgServiceImpl implements SeeImgService {

    @Autowired
    private SeeImgMapper seeImgDao;

    @Override
    public JsonBean deleteSeenImgById(Long id) {

        JsonBean bean  = new JsonBean();
        int i = seeImgDao.deleteByPrimaryKey(id);
        if ( i > 0){
            bean.setCode(0);
            bean.setInfo("Ok");
            return bean;
        }else{
            bean.setCode(-1);
            bean.setInfo("Error");
        }
        return bean;
    }

    @Override
    public JsonBean addSeeImg(SeeImg seeImg) {
        JsonBean bean  = new JsonBean();
        int i = seeImgDao.insert(seeImg);

        if ( i > 0){
            bean.setCode(0);
            bean.setInfo("Ok");
            return bean;
        }else{
            bean.setCode(-1);
            bean.setInfo("Error");
        }
        return bean;
    }

    /**
     *
     * @param seeImg
     *      传入的图片的实体类
     * @return
     *      返回json格式字符串
     *      正常：code = 0;
     *      异常:code = -1;
     */
    @Override
    public JsonBean addSeeImgSelective(SeeImg seeImg) {
        JsonBean bean  = new JsonBean();
        int i = seeImgDao.insertSelective(seeImg);

        if ( i > 0){
            bean.setCode(0);
            bean.setInfo("Ok");
            return bean;
        }else{
            bean.setCode(-1);
            bean.setInfo("Error");
        }
        return bean;

    }

    @Override
    public JsonBean selectSeeImgById(Long id) {

        JsonBean bean = new JsonBean();
        SeeImg img = seeImgDao.selectByPrimaryKey(id);
        if (img != null && !img.equals("")){
            bean.setCode(0);
            bean.setInfo(img);
        }else{
            bean.setCode(-1);
            bean.setInfo("Error");
        }

        return bean;
    }

    @Override
    public JsonBean updateByIdSelective(SeeImg seeImg) {

        JsonBean bean  = new JsonBean();
        int i = seeImgDao.updateByPrimaryKeySelective(seeImg);
        if ( i > 0){
            bean.setCode(0);
            bean.setInfo("Ok");
            return bean;
        }else{
            bean.setCode(-1);
            bean.setInfo("Error");
        }
        return bean;
    }

    @Override
    public JsonBean updateById(SeeImg seeImg) {

        JsonBean bean  = new JsonBean();
        int i = seeImgDao.updateByPrimaryKey(seeImg);
        if ( i > 0){
            bean.setCode(0);
            bean.setInfo("Ok");
            return bean;
        }else{
            bean.setCode(-1);
            bean.setInfo("Error");
        }
        return bean;

    }
}
