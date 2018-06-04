package com.sx.mvp.di;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Administrator
 * @Date 2018/6/4 0004 下午 1:37
 * @Description 注入注解
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectPresenter {
}
