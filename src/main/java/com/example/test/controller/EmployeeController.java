package com.example.test.controller;


import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.fastjson.JSONObject;
import com.example.test.common.JsonResult;
import com.example.test.bean.Employee;
import com.example.test.exception.ServiceException;
import com.example.test.service.EmployeeService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author twy
 * @since 2023-11-30
 */

@Api(value = "员工服务", tags = "员工模块")
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @ApiOperation(value = "创建员工信息")
    @PostMapping("/saveOrUpdate")
    public JsonResult saveOrUpdate(@RequestBody Employee employee){
        try{
            employeeService.saveOrUpdate(employee);
            return new JsonResult(employee);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new ServiceException("500","操作失败");
        }
    }

    @ApiOperation(value = "分页查询")
    @PostMapping("/findPage")
    public JsonResult findPage(@RequestBody JSONObject json){
        try{
            return new JsonResult( employeeService.findPage(json));
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new ServiceException("500","操作失败");
        }
    }

    @ApiOperation(value = "根据id查询")
    @GetMapping("/getById/{id}")
    public JsonResult getById(@PathVariable String id){
        try{
            return new JsonResult(employeeService.getById(id));
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new ServiceException("500","操作失败");
        }
    }

    @ApiOperation(value = "根据id删除")
    @DeleteMapping("/removeById/{id}")
    public JsonResult removeById(@PathVariable String id){
        try{
            return new JsonResult(employeeService.removeById(id));
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new ServiceException("500","操作失败");
        }
    }


    @ApiOperation(value = "根据ids批量删除")
    @PostMapping("/removeByIds")
    public JsonResult removeByIds(@RequestBody List<String> ids){
        try{
            return new JsonResult(employeeService.removeByIds(ids));
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new ServiceException("500","操作失败");
        }
    }



    @ApiOperation(value = "员工信息列表导出接口")
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        //查询所有用户
        List<Employee> list= employeeService.list();
        //在内存操作，写到浏览器
        ExcelWriter writer= ExcelUtil.getWriter(true);

        //自定义标题别名
        writer.addHeaderAlias("empName","职工姓名");
        writer.addHeaderAlias("sex","性别");
        writer.addHeaderAlias("age","年龄");
        writer.addHeaderAlias("deptName","部门名称");
        writer.addHeaderAlias("empDegreeName","学历");


        //默认配置
        writer.setOnlyAlias(true);
        writer.write(list,true);

        //设置content—type
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset:utf-8");

        //设置标题
        String fileName= URLEncoder.encode("职工列表","UTF-8");
        //Content-disposition是MIME协议的扩展，MIME协议指示MIME用户代理如何显示附加的文件。
        response.setHeader("Content-Disposition","attachment;filename="+fileName+".xlsx");
        ServletOutputStream outputStream= response.getOutputStream();

        //将Writer刷新到OutPut
        writer.flush(outputStream,true);
        outputStream.close();
        writer.close();
    }
}
