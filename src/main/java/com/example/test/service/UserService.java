package com.example.test.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.test.bean.User;
import com.example.test.common.JsonResult;

public interface UserService extends IService<User> {

    User getUserByUserId(String userId);

    JsonResult Login(JSONObject json);
}
