package com.sx.mvp.http;

import com.sx.mvp.MyApplication;
import com.sx.mvp.bean.BaseResponse;
import com.sx.mvp.http.exception.OtherException;
import com.sx.mvp.utils.NetUtil;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @Author Administrator
 * @Date 2018/6/4 0004 下午 3:29
 * @Description
 */

public class RxUtils {

    static final ObservableTransformer schedulersTransformer = upstream -> (upstream).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());


    public static <T> ObservableTransformer<T, T> applySchedulers() {
        return (ObservableTransformer<T, T>) schedulersTransformer;
    }


    /**
     * 统一返回结果处理
     *
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
     */
    public static <T> ObservableTransformer<BaseResponse<T>, T> handleResult() {
        return httpResponseObservable ->
                httpResponseObservable.flatMap((Function<BaseResponse<T>, Observable<T>>) baseResponse -> {
                    if (baseResponse.errorCode == BaseResponse.SUCCESS
                            && baseResponse.data != null
                            && NetUtil.isNetworkAvailable(MyApplication.AppContext)) {
                        return createData(baseResponse.data);
                    } else {
                        return Observable.error(new OtherException());
                    }
                });

    }


    /**
     * 得到 Observable
     * @param <T> 指定的泛型类型
     * @return Observable
     */
    private static <T> Observable<T> createData(final T t) {
        return Observable.create(emitter -> {
            try {
                emitter.onNext(t);
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });
    }
}
