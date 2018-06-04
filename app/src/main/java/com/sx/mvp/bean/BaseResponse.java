package com.sx.mvp.bean;

/**
 * @Author sunxin
 * @Date 2018/6/3 17:29
 * @Description
 */
public class BaseResponse<T> {
    public static final int SUCCESS = 0;


    public String errorMsg;
    public int errorCode;
    public T data;
}
