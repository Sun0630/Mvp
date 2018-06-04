package com.sx.mvp.mvp.article;

import com.orhanobut.logger.Logger;
import com.sx.mvp.bean.ArticleBean;
import com.sx.mvp.bean.BannerBean;
import com.sx.mvp.bean.BaseResponse;
import com.sx.mvp.http.RequestCallback;
import com.sx.mvp.mvp.base.BasePresenter;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * @Author sunxin
 * @Date 2018/6/3 18:00
 * @Description P 层，应该持有M和V的引用
 */
public class ArticleInfoPresenter extends BasePresenter<ArticleInfoContract.View> implements ArticleInfoContract.Presenter {

    private static final int STATE_CODE = 0;

    // 一个Presenter 对应多个Model应该如何做？  new ?

    private ArticleInfoContract.Model mModel;

    public ArticleInfoPresenter() {
        mModel = new ArticleInfoModel();
    }


    @Override
    public void getArticleList(int pageNum) {

        getView().onShowLoading();

        mModel
                .getArticleList(pageNum)
                .subscribe(new RequestCallback<BaseResponse<ArticleBean>>() {
                    @Override
                    protected void onSuccess(BaseResponse<ArticleBean> bean) {
                        // 因为进行了解绑操作，所以需要判断mView是否为空,挺烦的，可以在基类里面使用动态代理进行切面处理
                        getView().onHideLoading();
                        if (bean.errorCode == STATE_CODE) {
                            getView().showArticleList(bean);
                        } else {
                            getView().onError(bean.errorMsg);
                        }
                    }

                    @Override
                    protected void onFailer(Throwable e) {
                        getView().onError(e.getMessage());
                    }
                });
    }

    @Override
    public void getBanners() {

        mModel
                .getBanners()
                .subscribe(new Consumer<BaseResponse<List<BannerBean>>>() {
                    @Override
                    public void accept(BaseResponse<List<BannerBean>> bean) throws Exception {
                        Logger.e("--------------------------->>>>>>");
                        getView().onHideLoading();
                        if (bean.errorCode == STATE_CODE) {
                            getView().showBanner(bean);
                        } else {
                            getView().onError(bean.errorMsg);
                        }
                    }
                });
    }
}
