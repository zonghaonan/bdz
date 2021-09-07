package com.example.bdz.common.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author zhn
 * @Date 2021/9/4 17:00
 * @Version 1.0
 */
public class CaptchaException extends AuthenticationException {
    public CaptchaException(String msg) {
        super(msg);
    }
}
