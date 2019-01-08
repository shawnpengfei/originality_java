package com.ssy.app.service;

import com.ssy.app.utils.ResponseJson;

public interface UserService {
    ResponseJson login(String loginName,String password);
}
