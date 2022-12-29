package com.axzo.sample.shared.controller;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName Response
 * @Description
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
@Data
@Builder
public class Response<T> {
    Status status;
    String msg;
    T data;

    public static <T> Response<T> ok() {
        return Response.<T>builder().status(Status.SUCCESS).build();
    }

    public static <T> Response<T> ok(T data) {
        return Response.<T>builder().status(Status.SUCCESS).data(data).build();
    }

    public static <T> Response<T> failed(String msg) {
        return Response.<T>builder().status(Status.FAILED).msg(msg).build();
    }

    public enum Status {
        SUCCESS, FAILED
    }
}