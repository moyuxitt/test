package com.example.test.common;

public class JsonResult<T> {

    private Integer code;
    private String msg;
    private T data;


    public JsonResult() {
//        super();
        this.code = 200;
        this.msg = "操作成功";
    }

    public JsonResult(Integer code, String msg) {
//        super();
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(T data) {
//        super();
        this.code = 200;
        this.msg = "操作成功";
        this.data = data;
    }

    public JsonResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}
