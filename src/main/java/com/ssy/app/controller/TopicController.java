package com.ssy.app.controller;

import com.ssy.app.service.TopicService;
import com.ssy.app.vo.PageBeanVo;
import com.ssy.app.vo.ResultVo;
import com.ssy.app.vo.TopicVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@Api(produces = "这是话题接口文档",tags = "话题",value = "接口文档")
public class TopicController {

    @Autowired
    private TopicService topicService;

    //分页获取话题列表
    @GetMapping("/topicVoByPage")
    @CrossOrigin
    @ApiOperation(notes = "分页查询话题入口",value = "topicVoByPage")
    public PageBeanVo<TopicVo> topicVoByPage(int page,int limit){
        return topicService.queryPage(page,limit);
    }

    //根据分类ID获取话题
    @GetMapping("/selectBycid")
    @CrossOrigin
    @ApiOperation(notes = "根据分类ID查询话题入口",value = "topicVoByPage")
    public ResultVo selectBycid(int id){
        return topicService.selectBycid(id);
    }

    //根据ID查询话题
    @GetMapping("/selectById")
    @CrossOrigin
    @ApiOperation(notes = "根据ID查询话题入口",value = "selectById")
    public ResultVo selectById(int id){
        return topicService.selectById(id);
    }
}
