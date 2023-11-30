package com.example.test.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 用户名
     */
    private String userId;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否启用
     */
    private String enable;


    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")                    // 表示返回时间类型
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


    @TableField(exist = false)
    private String token;



}
