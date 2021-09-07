package com.example.bdz.common.lang;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author zhn
 * @Date 2021/9/3 15:16
 * @Version 1.0
 */
@Data
public class Result implements Serializable {
    private int code;
    private String msg;
    private Object data;

    public static Result success(Object data){
        return success(200,"操作成功",data);
    }
    public static Result success(int code,String msg,Object data){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
    public static Result fail(String msg){
        return fail(400,msg,null);
    }
    public static Result fail(int code,String msg,Object data){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
