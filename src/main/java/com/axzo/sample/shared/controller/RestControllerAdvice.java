package com.axzo.sample.shared.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName RestControllerAdvice
 * @Description 统一的异常处理类， 通过不同的异常类别，包装不同的 {@link Response } 对象
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
@org.springframework.web.bind.annotation.RestControllerAdvice
@Slf4j
public class RestControllerAdvice {
    /**
     * 错误处理
     *
     * @param throwable           异常
     * @param httpServletRequest  http 请求对象
     * @param httpServletResponse http 响应对象
     *                            return   {@link Response}
     */
    @ExceptionHandler(Throwable.class)
    public Response<Void> errorHandler(Throwable throwable, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        //可以根据异常类别，做判断，包装不同的响应
        Response<Void> response = Response.failed(throwable.getMessage());
        httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        StringBuilder builder = new StringBuilder();
        builder.append("Controller ErrorHandler")
                .append(" , ").append(httpServletRequest.getMethod()).append(" ").append(httpServletRequest.getRequestURI())
                .append(" , errorInfo ").append(throwable.getMessage())
                .append(" , responseHttpStatus [").append(httpServletResponse.getStatus()).append("]")
                .append(" , ").append(response.toString());
        log.error(builder.toString(), throwable);
        return response;
    }
}
