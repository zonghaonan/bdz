package com.example.bdz.security;

import cn.hutool.json.JSONUtil;
import com.example.bdz.common.lang.Result;
import com.example.bdz.utils.JwtUtils;
import com.example.bdz.utils.RedisUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
 * @Date 2021/9/6 19:28
 * @Version 1.0
 */
@Component
public class UserLogoutSuccessHandler implements LogoutSuccessHandler {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    RedisUtil redisUtil;
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //System.out.println(authentication);
        String jwt=httpServletRequest.getHeader(jwtUtils.getHeader());
        Claims claim=jwtUtils.getClaimByToken(jwt);
        if(claim==null){
            //System.out.println("token异常");
            throw new JwtException("token异常");
        }
        if(jwtUtils.isTokenExpired(claim)){
            throw new JwtException("token已过期");
        }
        if(redisUtil.hasKey("jwt:"+claim.get("username"))){
            redisUtil.del("jwt:"+claim.get("username"));
        }
        if(authentication!=null){
            new SecurityContextLogoutHandler().logout(httpServletRequest,httpServletResponse,authentication);
        }
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        httpServletResponse.setHeader(jwtUtils.getHeader(),"");
        Result result = Result.success(null);
        outputStream.write(JSONUtil.toJsonStr(result).getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
    }
}
