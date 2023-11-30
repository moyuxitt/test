package com.example.test.bean;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author twy
 * @since 2023-11-30
 */
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
      private String id;

    /**
     * 职员姓名
     */
    private String empName;

    /**
     * 性别，可选范围[男0，女1]
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 部门名称，可选范围[业务部，后勤部，人事部]
     */
    private String deptName;

    /**
     * 学历
     */
    private String empDegreeName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getEmpDegreeName() {
        return empDegreeName;
    }

    public void setEmpDegreeName(String empDegreeName) {
        this.empDegreeName = empDegreeName;
    }

    @Override
    public String toString() {
        return "Employee{" +
        "id = " + id +
        ", empName = " + empName +
        ", sex = " + sex +
        ", age = " + age +
        ", deptName = " + deptName +
        ", empDegreeName = " + empDegreeName +
        "}";
    }
}
