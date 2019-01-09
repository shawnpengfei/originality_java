package com.ssy.app.service.impl;

import com.ssy.app.dao.UserMapper;
import com.ssy.app.enity.User;
import com.ssy.app.service.UserService;
import com.ssy.app.utils.ResponseJson;
import com.ssy.app.utils.YhzUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ResponseJson login(String loginName, String password) {
        ResponseJson responseJson = null;
        Map<String,Object> map = new HashMap<>();
        User user = userMapper.selectByLoginName(loginName);
        try {
            if(user.getPassword().equals(password)){
                map.put("token", YhzUtils.sign(loginName,user.getId()));
                responseJson= YhzUtils.responseSuccess(map);
            }else{
                responseJson = YhzUtils.responseSuccess("登陆失败");
            }
        }catch (Exception e){
            responseJson = YhzUtils.responseSuccess("登陆失败");
        }
        return responseJson;
    }
}
