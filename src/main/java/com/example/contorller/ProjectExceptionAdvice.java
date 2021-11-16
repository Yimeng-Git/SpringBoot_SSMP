package com.example.contorller;

import com.example.utils.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public R MyException(Exception ex) {
        ex.printStackTrace();
        return new R(false, null, "服务器异常，请稍后重试....");
    }
}
