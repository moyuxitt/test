package com.example.test.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.test.bean.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author twy
 * @since 2023-11-30
 */
public interface EmployeeService extends IService<Employee> {
    IPage<Employee> findPage(JSONObject json);
}
