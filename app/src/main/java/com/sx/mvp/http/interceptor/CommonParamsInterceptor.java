package com.sx.mvp.http.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Author Administrator
 * @Date 2018/5/24 0024 下午 5:03
 * @Description 封装公共请求参数拦截器
 */

public class CommonParamsInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request
                .newBuilder()
//                .addHeader("DEVICE_TYPE","Android")
//                .addHeader("TOKEN","121211")
                .build();
        return chain.proceed(request);
    }
}
