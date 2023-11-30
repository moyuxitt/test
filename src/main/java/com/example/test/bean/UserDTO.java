package com.example.test.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private String id;
    private String userId;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")                    // 表示返回时间类型
    private LocalDateTime createTime;
    private String token;
}
