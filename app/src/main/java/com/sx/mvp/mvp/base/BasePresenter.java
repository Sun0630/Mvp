package com.sx.mvp.mvp.base;

/**
 * @Author sunxin
 * @Date 2018/6/3 20:44
 * @Description Presenter 的基类
 */
public class BasePresenter<V extends IBaseView> {

    public V mView;

    public void attach(V view) {
        this.mView = view;
    }

    public void detach() {
        //如果不解绑可能会造成内存泄漏
        this.mView = null;
    }

}
