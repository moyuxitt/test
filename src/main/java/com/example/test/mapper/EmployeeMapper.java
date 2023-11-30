package com.example.test.mapper;

import com.example.test.bean.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author twy
 * @since 2023-11-30
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}
