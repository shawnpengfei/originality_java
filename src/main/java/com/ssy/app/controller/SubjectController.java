package com.ssy.app.controller;

import com.ssy.app.enity.Subjectclass;
import com.ssy.app.service.SubjectService;
import com.ssy.app.vo.PageBeanVo;
import com.ssy.app.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(produces = "这是专题接口文档",tags = "专题",value = "接口文档")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;


        //获取所有专题
        @GetMapping("/subjectAll")
        @CrossOrigin
        @ApiOperation(notes = "查询专题入口",value = "selectByPage")
        public ResultVo selectAll() {
                return subjectService.selectAll();
        }
        //获取所有专题详情
        @PostMapping("/subjectclassByPage")
        @CrossOrigin
        @ApiOperation(notes = "分页查询专题详情入口",value = "subjectclassByPage")
        public PageBeanVo<Subjectclass> subjectclassByPage(int page, int limit){
            return subjectService.queryPage(page, limit);
        }

        //根据ID获取专题详情
        @PostMapping("/subjectclassById")
        @CrossOrigin
        @ApiOperation(notes = "根据ID查询专题详情入口",value = "subjectclassById")
        public ResultVo selectById(int id){
            return subjectService.selectById(id);
        }



}
