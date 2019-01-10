package com.ssy.app.controller;

//import com.ssy.app.service.SubjectService;
import com.ssy.app.vo.JsonBean;
import com.ssy.app.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@RestController
@Api(produces = "这是专题接口文档",value = "接口文档")
public class SubjectController {
/*
    @Autowired
    private SubjectService subjectService;

    //获取服务列表
    @GetMapping("/selectAll")
    @CrossOrigin
    @ApiOperation(notes = "分页查询专题入口",tags = {"分页查询专题"},value = "selectByPage")
    public ResultVo selectAll(){
        return subjectService.selectAll();
    }*/
}
