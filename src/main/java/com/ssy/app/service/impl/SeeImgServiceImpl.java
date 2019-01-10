package com.ssy.app.service.impl;

import com.ssy.app.dao.SeeImgCollectionMapper;
import com.ssy.app.dao.SeeImgMapper;
import com.ssy.app.enity.SeeImg;
import com.ssy.app.service.SeeImgService;
import com.ssy.app.vo.JsonBean;
import com.ssy.app.vo.PageBeanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SeeImgServiceImpl implements SeeImgService {

    @Autowired
    private SeeImgMapper seeImgDao;

    @Autowired
    private SeeImgCollectionMapper imgCollectionDao;

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
    public PageBeanVo<SeeImg> showSeeImgByClass(Long cid, Integer page, Integer count) {
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
    public JsonBean starImg(Long uid,Long id,Long starsNum) {
        JsonBean bean = new JsonBean();
        Map<String,Object> map = new HashMap<>();
        map.put("starsNum",starsNum);
        map.put("id",id);

        //在看图表中把收藏数增加1
        int i = seeImgDao.startImg(map);
        //在看图收藏表中插入收藏数据
        Map<String,Object> map1 = new HashMap<>();
        map1.put("imgid",id);
        map1.put("uid",uid);
        int j = imgCollectionDao.insertCollection(map1);

        if (i > 0 && j > 0){
            bean.setInfo("收藏成功");
            bean.setCode(0);
            return bean;
        } else{
            bean.setCode(-1);
            bean.setInfo("网络异常,请稍候重试!");
            return bean;
        }

    }

    @Override
    public PageBeanVo<SeeImg> showMystarImg(Long uid,Integer page,Integer limit) {
        PageBeanVo vo = new PageBeanVo();
        Map<String,Object> map = new HashMap<>();
        map.put("uid",uid);
        map.put("index",(page - 1) * limit);
        map.put("limit",limit);
        try {
            List<SeeImg> list = seeImgDao.showMyStarImg(map);
            vo.setCode(0);
            vo.setMsg("查询成功");
            vo.setCount(list.size());
            vo.setData(list);

        } catch (Exception e) {
            e.printStackTrace();
            vo.setCode(-1);
            vo.setMsg("暂无数据");
        }

        return vo;
    }
}
