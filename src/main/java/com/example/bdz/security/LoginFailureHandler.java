package com.example.bdz.security;

import cn.hutool.json.JSONUtil;
import com.example.bdz.common.lang.ErrorCode;
import com.example.bdz.common.lang.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author zhn
 * @Date 2021/9/4 16:08
 * @Version 1.0
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        //System.out.println(e.getMessage());
        Result result =null;
        if(e.getMessage().equals("Bad credentials")){
            result= Result.fail(ErrorCode.ERRORLOGIN);
        }else if (e.getMessage().equals("验证码错误")){
            result = Result.fail(ErrorCode.ERRORCAPTCHA);
        }else {
            result = Result.fail(e.getMessage());
        }
        outputStream.write(JSONUtil.toJsonStr(result).getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
    }
}
