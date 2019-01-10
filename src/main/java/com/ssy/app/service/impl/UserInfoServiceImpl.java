package com.ssy.app.service.impl;

import com.ssy.app.dao.UserInfoMapper;
import com.ssy.app.enity.UserInfo;
import com.ssy.app.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public boolean add(UserInfo userInfo) {
        return userInfoMapper.insertSelective(userInfo) > 0;
    }
}
