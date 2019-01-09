package com.ssy.app.service.impl;

import com.ssy.app.dao.SeeImgMapper;
import com.ssy.app.enity.SeeImg;
import com.ssy.app.service.SeeImgService;
import com.ssy.app.vo.JsonBean;
import com.ssy.app.vo.PageBeanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     *
     * @param page
     *      从第几页开始查
     * @param count
     *      每页显示图片的条数
     * @return
     *      正常：返回查到的图片的集合
     *      异常:返回异常状态
     */
    @Override
    public PageBeanVo<SeeImg> showImgAll(Integer page, Integer count) {
        PageBeanVo vo  = new PageBeanVo();
        List<SeeImg> list = null;
        try {
            list = seeImgDao.showImgAll(page, count);
            vo.setCode(0);
            vo.setCount(list.size());
            vo.setData(list);
            vo.setMsg("图片查询成功");

        } catch (Exception e) {
            e.printStackTrace();
            vo.setCode(-1);
            vo.setMsg("暂无数据");
        }

        return vo;

    }

    @Override
    public PageBeanVo<SeeImg> showSeeImgByClass(Integer cid, Integer page, Integer count) {
        PageBeanVo vo  = new PageBeanVo();
        List<SeeImg> list = null;

        try {
            list = seeImgDao.showSeeImgByclass(cid,page,count);
            vo.setCode(0);
            vo.setCount(list.size());
            vo.setData(list);
            vo.setMsg("图片查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            vo.setCode(-1);
            vo.setMsg("暂无数据");
        }


        return vo;
    }

    @Override
    public JsonBean starImg(Integer star) {



        return null;
    }
}
