package com.ssy.app.service.impl;

import com.ssy.app.dao.UserInfoMapper;
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
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public ResponseJson login(String loginName, String password) {
        ResponseJson responseJson = null ;
        Map<String,Object> map = new HashMap<>();
        User user = userMapper.selectByLoginName(loginName);
        try {
            if(user.getPassword().equals(password)){
                long id = userInfoMapper.selectIdByUid(user.getId());
                map.put("token", YhzUtils.sign(loginName,user.getId()));
                map.put("userId", id);
                responseJson= YhzUtils.responseSuccess(map);
            }else{
                responseJson = YhzUtils.responseSuccess("登陆失败");
            }
        }catch (Exception e){
            responseJson = YhzUtils.responseSuccess("登陆失败");
        }
        return responseJson;
    }

    @Override
    public int addUser(User user) {
        if (userMapper.selectByLoginName(user.getLoginName()) == null){
            if (userMapper.insertSelective(user) > 0){
                return userMapper.selectMaxId();
            }
        }
        return 0;
    }
}
