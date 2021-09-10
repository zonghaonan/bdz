package com.example.bdz.common.exception;

import com.example.bdz.common.lang.ErrorCode;
import com.example.bdz.common.lang.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author zhn
 * @Date 2021/9/3 15:25
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handler(MethodArgumentNotValidException e){
        BindingResult result=e.getBindingResult();
        ObjectError objectError = result.getAllErrors().stream().findFirst().get();
        log.error("实体校验异常：-----------{}",objectError.getDefaultMessage());
        return Result.fail(ErrorCode.INVALIDPARAM.code(),objectError.getDefaultMessage(),null);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Result handler(IllegalArgumentException e){
        log.error("Assert异常：-----------{}",e.getMessage());
        return Result.fail(ErrorCode.NOTFOUND.code(),e.getMessage(),null);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public Result handler(RuntimeException e){
        log.error("运行时异常：-----------{}",e.getMessage());
        if(e.getMessage().equals("不允许访问")){
            return Result.fail(ErrorCode.UNAUTHORISE);
        }
        return Result.fail(ErrorCode.SERVER_ERROR);
    }
}
