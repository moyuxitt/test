package com.example.test.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.test.bean.User;
import com.example.test.bean.UserDTO;
import com.example.test.common.JsonResult;
import com.example.test.mapper.UserMapper;
import com.example.test.service.UserService;
import com.example.test.utils.TokenUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserByUserId(String userId){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserId,userId);
        return userMapper.selectOne(wrapper);
    }

    public JsonResult Login(JSONObject json){
        if(json.containsKey("userId") && json.containsKey("password")){
            User user;
            UserDTO userDTO = new UserDTO();
            LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(User::getUserId,json.getString("userId"));
            wrapper.eq(User::getPassword,json.getString("password"));
            user = this.getOne(wrapper);
            if(user != null){
                if(!user.getEnable().equals("1")){
                    return new JsonResult(500,"帐号未被启用，请联系管理员");
                }
                BeanUtils.copyProperties(user,userDTO);
                userDTO.setToken(TokenUtils.genToken(json.getString("userId"),"123"));
                return new JsonResult(userDTO);
            }else {
                return new JsonResult(500,"用户名不存在或密码错误");
            }
        }else {
            return new JsonResult(500,"参数错误");
        }
    }
}
