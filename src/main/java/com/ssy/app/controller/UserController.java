package com.ssy.app.controller;


import com.ssy.app.enity.User;
import com.ssy.app.enity.UserInfo;
import com.ssy.app.service.UserInfoService;
import com.ssy.app.service.UserService;
import com.ssy.app.utils.ResponseJson;
import com.ssy.app.utils.YhzUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(produces = "这是Java编写的接口文档",tags = "登陆注册",value = "登陆注册")
public class UserController {
    private final static ThreadLocal<String> vo = new ThreadLocal<>();
    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoService userInfoService;
    //用户注册
    @GetMapping("/register")
    @CrossOrigin
    @ApiOperation(notes = "注册接口",value = "注册接口")
    public ResponseJson register(@ApiParam(name="loginName",value="用户名",required=true) String loginName,
                                 @ApiParam(name="password",value="密码",required=true)String password,
                                 @ApiParam(name="nickName",value="昵称",required=true)String nickName,
                                 @ApiParam(name="validateCode",value="验证码",required=true)String validateCode ,
                                 @ApiParam(name="phoneNumber",value="手机号",required=true)String phoneNumber){
        String v = vo.get();
        System.out.println(v);
        if (v!=null&&!v.equals(validateCode)){
            return YhzUtils.responseError("验证码错误");
        }
        User user = new User();
        user.setLoginName(loginName);
        user.setPassword(password);
        long uid=userService.addUser(user);
        if(uid>0){
            UserInfo userInfo = new UserInfo();
            userInfo.setNickname(nickName);
            userInfo.setUid(uid);
            userInfo.setPhonenumber(phoneNumber);
            userInfoService.add(userInfo);
        } else{
            return YhzUtils.responseError("用户名已存在");
        }

        return YhzUtils.responseSuccess("注册成功");
    }

    @GetMapping("/validator")
    @CrossOrigin
    @ApiOperation(notes = "获取手机验证码",value = "获取验证码")
    public String validatorCode(){
        String validate = YhzUtils.setValidator();
        vo.set(validate);
        return validate;
    }
    @GetMapping("/login")
    @CrossOrigin
    @ApiOperation(notes = "登录接口，成功后返回用户的登陆令牌和用户id,所有的接口请求头中都要有登陆令牌来验证登陆用户",
            value = "登陆接口，成功后返回用户的登陆令牌和用户id")
    public ResponseJson login(String loginName,String password){
        return userService.login(loginName,password);
    }
}
