package com.example.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.test.bean.User;
import com.example.test.common.JsonResult;
import com.example.test.exception.ServiceException;
import com.example.test.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;




    @PostMapping(value = "/saveOrUpdate")
    public JsonResult saveOrUpdate(@RequestBody User user){
        try{
            userService.saveOrUpdate(user);
            return new JsonResult(200,"操作成功",user);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new ServiceException("500","操作失败");
        }
    }


    @PostMapping("/Login")
    public JsonResult Login(@RequestBody JSONObject json){
        try{
            return userService.Login(json);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new ServiceException("500","操作失败");
        }
    }
}
