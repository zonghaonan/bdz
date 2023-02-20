package com.example.bdz.common.lang;

/**
 * @Author zhn
 * @Date 2021/9/10 9:30
 * @Version 1.0
 */
public enum  ErrorCode implements ResultCode {
    UNAUTHENTICATED(false,10001,"登录异常,请重新登录！"),
    UNAUTHORISE(false,10002,"权限不足,无权操作！"),
    INVALIDPARAM(false,10003,"非法参数"),
    NOTFOUND(false,10004,"找不到内容"),
    ERRORLOGIN(false,10005,"用户名或密码错误"),
    ERRORCAPTCHA(false,10006,"验证码错误"),
    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后重试！");
    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private ErrorCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }
    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
