package com.example.bdz.security;

import cn.hutool.json.JSONUtil;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwUser;
import com.example.bdz.utils.JwtUtils;
import com.example.bdz.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhn
 * @Date 2021/9/4 16:08
 * @Version 1.0
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    RedisUtil redisUtil;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        //生成jwt，并放置到请求头中
        AccountUser accountUser= (AccountUser) authentication.getPrincipal();
        Map<String,Object> msg=new HashMap<>();
        msg.put("username",accountUser.getUsername());
        msg.put("userId",accountUser.getUserId());
        String jwt = jwtUtils.generateToken(msg);
        System.out.println("jwt:"+jwt);
        redisUtil.set("jwt:"+authentication.getName(),jwt,604800);
        httpServletResponse.setHeader(jwtUtils.getHeader(),jwt);
        Result result = Result.success(null);
        outputStream.write(JSONUtil.toJsonStr(result).getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
    }
}
