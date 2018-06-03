package com.sx.mvp.mvp.article;

import com.sx.mvp.bean.BaseBean;
import com.sx.mvp.bean.TestBean;
import com.sx.mvp.http.RequestCallback;

/**
 * @Author sunxin
 * @Date 2018/6/3 18:00
 * @Description P 层，应该持有M和V的引用
 */
public class ArticleInfoPresenter implements ArticleInfoContract.Presenter {

    private ArticleInfoContract.View mView;
    private ArticleInfoContract.Model mModel;

    public ArticleInfoPresenter(ArticleInfoContract.View view) {
        mView = view;
        mModel = new ArticleInfoModel();
    }

    /**
     * 绑定View
     *
     * @param view
     */
    public void attachView(ArticleInfoContract.View view) {
        this.mView = view;
    }

    /**
     * 解绑View
     */
    public void detachView() {
        this.mView = null;
    }

    @Override
    public void getArticleList(int pageNum) {

        mView.onShowLoading();

        mModel
                .getArticleList(pageNum)
                .subscribe(new RequestCallback<BaseBean<TestBean>>() {
                    @Override
                    protected void onSuccess(BaseBean<TestBean> bean) {
                        // 因为进行了解绑操作，所以需要判断mView是否为空,挺烦的
                        if (mView != null) {
                            mView.onHideLoading();
                            if (bean.errorCode == 200) {
                                mView.onSuccess(bean);
                            } else {
                                mView.onError(bean.errorMsg);
                            }
                        }
                    }

                    @Override
                    protected void onFailer(Throwable e) {
                        if (mView != null) {
                            mView.onError(e.getMessage());
                        }
                    }
                });
    }
}
