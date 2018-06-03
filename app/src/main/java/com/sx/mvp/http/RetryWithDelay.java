package com.sx.mvp.http;

import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * @Author sunxin
 * @Date 2018/5/23 0023 下午 2:08
 * @Description 出错重连的次数
 */

public class RetryWithDelay implements Function<Observable<? extends Throwable>, Observable<?>> {

    private final int maxRetries;
    private final int retryDelaySeconds;
    private int retryCount;

    public RetryWithDelay(int maxRetries, int retryDelaySeconds) {
        this.maxRetries = maxRetries;
        this.retryDelaySeconds = retryDelaySeconds;
    }


    @Override
    public Observable<?> apply(Observable<? extends Throwable> observable) throws Exception {
        return observable.flatMap(new Function<Throwable, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Throwable throwable) throws Exception {

                Logger.e("发生了异常---> " + throwable.toString());

                if (++retryCount <= maxRetries) {
                    // When this Observable calls onNext, the original Observable will be retried (i.e. re-subscribed).
                    Logger.e("get error, it will try after " + retryDelaySeconds + " millisecond, retry count " + retryCount);
                    return Observable.timer(retryDelaySeconds,
                            TimeUnit.SECONDS);
                }
                // Max retries hit. Just pass the error along.
                return Observable.error(throwable);
            }
        });
    }
}
