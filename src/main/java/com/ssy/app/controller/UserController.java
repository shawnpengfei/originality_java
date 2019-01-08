package com.ssy.app.controller;


import com.ssy.app.utils.ResponseJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(produces = "这是Java编写的接口文档",value = "接口文档")
public class UserController {

    @GetMapping("/test")
    @ApiOperation(notes = "测试一下",tags = {"测试用的"},value = "hello word")
    public String getStr(){
        return "hello";
    }

    @GetMapping("/login")
    public ResponseJson login(String loginName,String password){

        return null;
    }
}
