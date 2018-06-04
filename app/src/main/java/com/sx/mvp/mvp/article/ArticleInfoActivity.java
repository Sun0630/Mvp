package com.sx.mvp.mvp.article;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.sx.mvp.R;
import com.sx.mvp.bean.BannerBean;
import com.sx.mvp.bean.BaseResponse;
import com.sx.mvp.bean.ArticleBean;
import com.sx.mvp.di.InjectPresenter;
import com.sx.mvp.mvp.base.BaseActivity;
import com.sx.mvp.utils.ImageLoaderUtil;

import java.util.List;

/**
 * @Author sunxin
 * @Date 2018/6/3 17:59
 * @Description V 层
 */
public class ArticleInfoActivity extends BaseActivity implements ArticleInfoContract.View {


    private TextView mTextView;

    private ImageView mBannerView;

    // 一个View肯定会有对应多个Presenter的情况出现。  ①，Dagger2   ②，字节创建注解，使用反射解析

    @InjectPresenter
    ArticleInfoPresenter mInfoPresenter;


    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mTextView = findViewById(R.id.tv_info);
        mBannerView = findViewById(R.id.iv_banner);
    }

    @Override
    protected void initData() {
        mInfoPresenter.getArticleList(0);
        mInfoPresenter.getBanners();
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
    public void onSuccess(BaseResponse<ArticleBean> bean) {

    }

    @Override
    public void showArticleList(BaseResponse<ArticleBean> bean) {
        // 成功，但是如果这个时候界面被强制销毁了，很可能会造成View为空。
        //需要绑定View与解绑View
        mTextView.setText(bean.data.getDatas().get(0).getChapterName());
        Logger.e(bean.toString());
    }

    @Override
    public void showBanner(BaseResponse<List<BannerBean>> bannerBean) {
        Logger.e("banner-->"+bannerBean.data.get(0).getImagePath());
        ImageLoaderUtil.LoadImage(this,bannerBean.data.get(0).getImagePath(),mBannerView);
    }
}
