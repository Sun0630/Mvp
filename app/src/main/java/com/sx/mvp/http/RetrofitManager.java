package com.sx.mvp.http;

import android.support.annotation.NonNull;

import com.sx.mvp.BuildConfig;
import com.sx.mvp.Constant;
import com.sx.mvp.MyApplication;
import com.sx.mvp.http.interceptor.CacheInterceptor;
import com.sx.mvp.http.interceptor.CommonParamsInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * @Author sunxin
 * @Date 2018/5/23 0023 上午 10:27
 * @Description 网络请求管理器
 */

public class RetrofitManager {

    public static final int OKHTTP_CONNECT_TIMEOUT = 10;
    public static final int OKHTTP_READ_TIMEOUT = 15;
    public static final int OKHTTP_WRITE_TIMEOUT = 15;
    private volatile static Retrofit retrofit;

    public static OkHttpClient.Builder initInterceptor(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);
        return builder;
    }

    @NonNull
    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            synchronized (RetrofitManager.class) {
                if (retrofit == null) {
                    // 指定缓存路径,缓存大小 50Mb
                    Cache cache = new Cache(new File(MyApplication.AppContext.getCacheDir(), "HttpCache"),
                            1024 * 1024 * 50);


                    OkHttpClient.Builder builder = new OkHttpClient.Builder()
                            .cache(cache)
                            //缓存拦截器
                            .addInterceptor(new CacheInterceptor())
                            //添加公共参数拦截器
                            .addInterceptor(new CommonParamsInterceptor())
                            .connectTimeout(OKHTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                            .readTimeout(OKHTTP_READ_TIMEOUT, TimeUnit.SECONDS)
                            .writeTimeout(OKHTTP_WRITE_TIMEOUT, TimeUnit.SECONDS)
                            .retryOnConnectionFailure(true);

                    // Log 拦截器
                    if (BuildConfig.DEBUG) {
                        builder = initInterceptor(builder);
                    }

                    retrofit = new Retrofit.Builder()
                            .baseUrl(Constant.BASE_URL)
                            .client(builder.build())
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }
        }
        return retrofit;
    }
}
