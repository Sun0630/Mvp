package com.sx.mvp.mvp.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import com.sx.mvp.di.InjectPresenter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author sunxin
 * @Date 2018/6/3 20:36
 * @Description 创建基类
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {


    private List<BasePresenter> mPresenterList;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayoutId());

        mPresenterList = new ArrayList<>();
        // Activity .   Fragment     ViewGroup
        //使用反射注入
        injectionPresenter();

        initView();
        initData();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void injectionPresenter() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            //拿到带有这个注解的字段
            InjectPresenter injectPresenter = field.getAnnotation(InjectPresenter.class);

            if (injectPresenter != null) {
                Class<? extends BasePresenter> presenterClazz = null;

                // 判断注解类型是否有错


                presenterClazz = (Class<? extends BasePresenter>) field.getType();


                Class<?> superclass1 = presenterClazz.getSuperclass();

                if (!superclass1.getName().equals(BasePresenter.class.getName())) {
                    throw new IllegalArgumentException("字段注入类型不正确！" + superclass1.getName());
                }


                //创建Presenter对象
                try {
                    BasePresenter presenter = presenterClazz.newInstance();
                    // 绑定，注意，也需要解绑
                    presenter.attach(this);
                    // 每次绑定的时候就加入到集合中
                    mPresenterList.add(presenter);
                    // 设置访问可见
                    field.setAccessible(true);
                    // 为字段设置值
                    field.set(this, presenter);

                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }


            }

        }
    }

    /**
     * 创建P层，使用注入创建，不在手动new
     *
     * @return
     */
//    protected abstract P createPresenter();

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
        //遍历集合，解绑
        for (BasePresenter presenter : mPresenterList) {
            presenter.detach();
        }
    }
}
