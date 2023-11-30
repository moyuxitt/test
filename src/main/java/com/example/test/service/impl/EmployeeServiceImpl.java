package com.example.test.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.test.bean.Employee;
import com.example.test.mapper.EmployeeMapper;
import com.example.test.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author twy
 * @since 2023-11-30
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    public IPage<Employee> findPage(JSONObject json){
        int pageNum = 1;
        int pageSize = 10;
        if(json.containsKey("pageNum")){
            pageNum = json.getInteger("pageNum");
        }
        if(json.containsKey("pageSize")){
            pageSize = json.getInteger("pageSize");
        }

        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        if(json.containsKey("empName")){
            wrapper.eq(Employee::getEmpName,json.getString("empName"));
        }
        if(json.containsKey("deptName")){
            wrapper.eq(Employee::getDeptName,json.getString("deptName"));
        }
        if(json.containsKey("empDegreeName")){
            wrapper.eq(Employee::getEmpDegreeName,json.getString("empDegreeName"));
        }

        IPage<Employee> iPage = new Page<>(pageNum,pageSize);
        IPage page = this.page(iPage,wrapper);
        return page;
    }
    
}
