package com.example.test.utils.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import com.example.test.exception.ServiceException;
import com.example.test.bean.User;
import com.example.test.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token =  request.getHeader("token");
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        if (StringUtils.isBlank(token)) {
            throw new ServiceException("500","无token，请重新登录");
        }
        String userId;
        try {
             userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            log.error("-------------------------------,"+j);
            throw new ServiceException("401","token验证失败，错误代码401");
        }
        User user = userService.getUserByUserId(userId);
        if (user == null) {
            throw new ServiceException("500","用户不存在，请重新登录");
        }
        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("123")).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            log.error("-------------------------------,"+e);
            throw new ServiceException("401","token验证失败，错误代码401");
        }
        return true;
    }
}
