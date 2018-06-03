package com.sx.mvp.mvp.article;

import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.sx.mvp.R;
import com.sx.mvp.bean.BaseBean;
import com.sx.mvp.bean.TestBean;
import com.sx.mvp.mvp.base.BaseActivity;

/**
 * @Author sunxin
 * @Date 2018/6/3 17:59
 * @Description V 层
 */
public class ArticleInfoActivity extends BaseActivity<ArticleInfoPresenter> implements ArticleInfoContract.View {


    private TextView mTextView;

    @Override
    protected ArticleInfoPresenter createPresenter() {
        return new ArticleInfoPresenter();
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mTextView = findViewById(R.id.tv_info);
    }

    @Override
    protected void initData() {
        mPresenter.getArticleList(0);
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

}
