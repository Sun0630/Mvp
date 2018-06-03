package com.sx.mvp.http;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @Author sunxin
 * @Date 2018/5/23 0023 下午 1:51
 * @Description 自定义 Observer
 */

public abstract class RequestCallback<T> implements Observer<T> {


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }


    @Override
    public void onError(Throwable e) {
        onFailer(e);
    }


    @Override
    public void onComplete() {

    }


    /**
     * 请求成功
     * @param t
     */
    protected abstract void onSuccess(T t);

    /**
     * 请求失败
     * @param e
     */
    protected abstract void onFailer(Throwable e);


}
