package com.example.bdz.security;

import cn.hutool.core.util.StrUtil;
import com.example.bdz.pojo.GwUser;
import com.example.bdz.service.GwUserService;
import com.example.bdz.utils.JwtUtils;
import com.example.bdz.utils.RedisUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author zhn
 * @Date 2021/9/5 10:18
 * @Version 1.0
 */
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    GwUserService gwUserService;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    UserDetailServiceImpl userDetailService;
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String jwt=request.getHeader(jwtUtils.getHeader());
        if(StrUtil.isEmptyOrUndefined(jwt)){
            chain.doFilter(request,response);
            return;
        }
        Claims claim=jwtUtils.getClaimByToken(jwt);
        if(claim==null){
            //System.out.println("token异常");
            throw new JwtException("token异常");
        }
        if(jwtUtils.isTokenExpired(claim)){
            throw new JwtException("token已过期");
        }
        //System.out.println("异常结束");
        String username= (String) claim.get("username");
        Long userId= (Long) claim.get("userId");
        if(!redisUtil.hasKey("jwt:"+username)){
            throw new JwtException("token不存在");
        }
        //System.out.println("claim:"+claim.get("userId"));
        //获取用户的权限等信息
        //GwUser gwUser = gwUserService.getByUsername(username);
        //System.out.println(username);
        UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(username,null,userDetailService.getUserAuthority(userId));
        SecurityContextHolder.getContext().setAuthentication(token);
        chain.doFilter(request,response);
    }
}
