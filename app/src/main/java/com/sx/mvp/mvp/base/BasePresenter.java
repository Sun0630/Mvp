package com.sx.mvp.mvp.base;

import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;

/**
 * @Author sunxin
 * @Date 2018/6/3 20:44
 * @Description Presenter 的基类
 */
public class BasePresenter<V extends IBaseView> {

    /**
     * 是一个接口,可以使用弱引用
     */
    public WeakReference<V> mView;

    /**
     * 代理对象
     */
    public V mProxyView;

    public void attach(V view) {
        this.mView = new WeakReference<>(view);
        mProxyView = (V) Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(), (proxy, method, args) -> {
            //用到View的地方都会走到这里
            if (mView == null || mView.get() == null) {
                return null;
            }
            return method.invoke(mView.get(), args);
        });
    }

    public void detach() {
        //如果不解绑可能会造成内存泄漏
        this.mView = null;
        this.mView.clear();
        this.mProxyView = null;
    }

    public V getView() {
        return mProxyView;
    }
}
