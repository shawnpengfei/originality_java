package com.ssy.app.service.impl;

import com.ssy.app.dao.TopicDiscussMapper;
import com.ssy.app.dao.TopicMapper;
import com.ssy.app.service.TopicService;
import com.ssy.app.vo.PageBeanVo;
import com.ssy.app.vo.ResultVo;
import com.ssy.app.vo.TopicVo;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * //
 * //                       _oo0oo_
 * //                      o8888888o
 * //                      88" . "88
 * //                      (| -_- |)
 * //                      0\  =  /0
 * //                    ___/`---'\___
 * //                  .' \\|     |// '.
 * //                 / \\|||  :  |||// \
 * //                / _||||| -:- |||||- \
 * //               |   | \\\  -  /// |   |
 * //               | \_|  ''\---/''  |_/ |
 * //               \  .-\__  '-'  ___/-. /
 * //             ___'. .'  /--.--\  `. .'___
 * //          ."" '<  `.___\_<|>_/___.' >' "".
 * //         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 * //         \  \ `_.   \_ __\ /__ _/   .-` /  /
 * //     =====`-.____`.___ \_____/___.-`___.-'=====
 * //                       `=---='
 * //
 * //
 * //     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * //
 * //               佛祖保佑         永无BUG
 * //
 */
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicDao;

    @Autowired
    private TopicDiscussMapper topicDiscussDao;

    //分页哈讯话题列表
    @Override
    public PageBeanVo<TopicVo> queryPage(int page, int limit) {
        Map<String,Object> map = new HashedMap();
        map.put("index",(page-1)*limit);
        map.put("limit",limit);
        return PageBeanVo.setPage(topicDao.selectCount(),topicDao.selectByPage(map));
    }

    //根据分类ID获取话题
    @Override
    public ResultVo selectBycid(int id) {
        List<TopicVo> topicVos = topicDao.selectBycid(id);
        if (topicVos!=null){
            return ResultVo.setOK(topicVos);
        }else{
            return ResultVo.setERROR();
        }
    }

    //根据ID查询话题
    @Override
    public ResultVo selectById(int id) {
        TopicVo topicVo = topicDiscussDao.selectById(id);
        if (topicVo!=null){
            return ResultVo.setOK(topicVo);
        }else{
            return ResultVo.setERROR();
        }
    }
}
