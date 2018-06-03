package com.sx.mvp;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * @Author sunxin
 * @Date 2018/6/3 17:31
 * @Description
 */
public class MyApplication extends Application {
    public static Context AppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        AppContext = getApplicationContext();
        initLogger();
    }



    private void initLogger() {
        FormatStrategy formatStrategt = PrettyFormatStrategy
                .newBuilder()
                .showThreadInfo(true)
                .tag("Mvp")
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategt) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }
}
