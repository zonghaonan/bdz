package com.example.bdz.security;

import com.example.bdz.common.exception.CaptchaException;
import com.example.bdz.common.lang.Const;
import com.example.bdz.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author zhn
 * @Date 2021/9/4 16:25
 * @Version 1.0
 */
@Component
public class CaptchaFilter extends OncePerRequestFilter {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    LoginFailureHandler failureHandler;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String url=httpServletRequest.getRequestURI();
        if("/login".equals(url)){
            try {
                //校验验证码
                validate(httpServletRequest);
            }catch (CaptchaException e){
                //交给认证失败处理器
                failureHandler.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    private void validate(HttpServletRequest httpServletRequest) {
        String key=httpServletRequest.getParameter("key");
        String code=httpServletRequest.getParameter("code");
        if(StringUtils.isEmpty(key)||StringUtils.isEmpty(code)){
            throw new CaptchaException("验证码错误");
        }
        if(!code.equals(redisUtil.hget(Const.CAPTCHA_KEY,key))){
            throw new CaptchaException("验证码错误");
        }
        redisUtil.hdel(Const.CAPTCHA_KEY,key);
    }
}
