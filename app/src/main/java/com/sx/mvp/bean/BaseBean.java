package com.sx.mvp.bean;

import java.io.Serializable;

/**
 * @Author sunxin
 * @Date 2018/6/3 17:29
 * @Description
 */
public class BaseBean<T extends Serializable> {
    public String errorMsg;
    public int errorCode;
    public T data;
}
