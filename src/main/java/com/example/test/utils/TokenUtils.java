package com.example.test.utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.test.exception.ServiceException;
import com.example.test.bean.User;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Component
public class TokenUtils {



    public static UserService staticUserService;

    @Autowired
    private UserService userService;


    @PostConstruct
    public void init(){
        staticUserService = this.userService;
    }


    /**
     * 生成token
     * @param userId
     * @param sign
     * @return
     */
    public static String genToken(String userId,String sign){
        return JWT.create().withAudience(userId) // 将 user id 保存到 token 里面
                .withExpiresAt(DateUtil.offsetHour(new Date(),72)) //24h后token过期
                .sign(Algorithm.HMAC256(sign));
    }

    /**
     * 获取登陆用户数据
     */
    public static User getCurrentUser(){
        try{
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            if(StringUtils.isNotBlank(token)){
                String userid = JWT.decode(token).getAudience().get(0);
                User user = staticUserService.getById(userid);
                return user;
            }
        }catch (Exception e){
            throw new ServiceException("500",e.toString());
        }
        return null;
    }
}
