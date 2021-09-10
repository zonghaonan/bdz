package com.example.bdz.common.lang;

/**
 * @Author zhn
 * @Date 2021/9/10 9:27
 * @Version 1.0
 */
public interface ResultCode {
    //操作是否成功,true为成功，false操作失败
    boolean success();
    //操作代码
    int code();
    //提示信息
    String message();

}
