package com.sx.mvp.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @Author sunxin
 * @Date 2018/6/3 20:36
 * @Description 创建基类
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayoutId());
        // 在这里创建 P 需要交给子类完成
        mPresenter = createPresenter();
        mPresenter.attach(this);

        initView();
        initData();
    }

    /**
     * 创建P层
     *
     * @return
     */
    protected abstract P createPresenter();

    /**
     * 传入LayoutId
     *
     * @return
     */
    protected abstract int getContentLayoutId();

    /**
     * 初始化视图
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }
}
