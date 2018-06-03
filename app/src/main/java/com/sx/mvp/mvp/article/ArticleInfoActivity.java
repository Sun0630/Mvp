package com.sx.mvp.mvp.article;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.sx.mvp.R;
import com.sx.mvp.bean.BaseBean;
import com.sx.mvp.bean.TestBean;

/**
 * @Author sunxin
 * @Date 2018/6/3 17:59
 * @Description V 层
 */
public class ArticleInfoActivity extends AppCompatActivity implements ArticleInfoContract.View {


    private TextView mTextView;
    private ArticleInfoPresenter mArticleInfoPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.tv_info);
        mArticleInfoPresenter = new ArticleInfoPresenter(this);
        //绑定View
        mArticleInfoPresenter.attachView(this);
        mArticleInfoPresenter.getArticleList(0);
    }

    @Override
    public void onShowLoading() {
        Logger.e("onShowLoading");
    }

    @Override
    public void onHideLoading() {
        Logger.e("onHideLoading");
    }

    @Override
    public void onError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
        Logger.e(errorMsg);
    }


    @Override
    public void onNetWorkError() {

    }

    @Override
    public void onSuccess(BaseBean<TestBean> bean) {
        // 成功，但是如果这个时候界面被强制销毁了，很可能会造成View为空。
        //需要绑定View与解绑View
        mTextView.setText(bean.data.getDatas().get(0).getChapterName());
        Logger.e(bean.toString());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑View
        mArticleInfoPresenter.detachView();
    }
}
