package com.ssy.app.controller;

import com.ssy.app.enity.Stylist;
import com.ssy.app.service.StyService;
import com.ssy.app.vo.PageBeanVo;
import com.ssy.app.vo.ResultVo;
import com.ssy.app.vo.StyVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(produces = "这是设计师接口文档",tags = "设计师",value = "接口文档")
public class StyController {
    @Autowired
    private StyService styService;

    //分页查询设计师
    @GetMapping("/styVoByPage")
    @CrossOrigin
    @ApiOperation(notes = "分页查询设计师详情入口",value = "styVoByPage")
    public PageBeanVo<StyVo> styVoByPage(int page, int limit){
        return styService.queryPage(page, limit);
    }

    //根据城市名称查询设计师
    @GetMapping("/styVoByCity")
    @CrossOrigin
    @ApiOperation(notes = "根据城市查询设计师入口",value = "styVoByCity")
    public ResultVo styVoByCity(String name){
        return styService.selectByCity(name);
    }

    //根据城市ID查询设计师
    @GetMapping("/styVoBycid")
    @CrossOrigin
    @ApiOperation(notes = "根据城市ID查询设计师入口",value = "styVoBycid")
    public ResultVo styVoBycid(int id){
        return styService.selectBycid(id);
    }

    //根据ID查询设计师信息
    @GetMapping("/stylistById")
    @CrossOrigin
    @ApiOperation(notes = "根据ID查询设计师信息入口",value = "stylistById")
    public ResultVo stylistById(int id){
        return styService.selectById(id);
    }

    //根据ID查询设计师地址
    @GetMapping("/styVoAddr")
    @CrossOrigin
    @ApiOperation(notes = "根据ID查询设计师地址入口",value = "styVoAddr")
    public ResultVo styVoAddr(int id){
        return styService.selectAddr(id);
    }

    //添加设计师
    @PostMapping("/stylistadd")
    @CrossOrigin
    @ApiOperation(notes = "添加设计师信息入口",value = "stylistadd")
    public ResultVo stylistadd(Stylist stylist){
        return styService.addSty(stylist);
    }

    //查询地区列表
    @GetMapping("styareaall")
    @CrossOrigin
    @ApiOperation(notes = "查询地区列表",value = "styareaall")
    public ResultVo styareaall(){
        return styService.selectAll();
    }
}
