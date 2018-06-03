package com.sx.mvp.mvp.article;

import com.sx.mvp.bean.BaseBean;
import com.sx.mvp.bean.TestBean;
import com.sx.mvp.http.RequestCallback;
import com.sx.mvp.mvp.base.BasePresenter;

/**
 * @Author sunxin
 * @Date 2018/6/3 18:00
 * @Description P 层，应该持有M和V的引用
 */
public class ArticleInfoPresenter extends BasePresenter<ArticleInfoContract.View> implements ArticleInfoContract.Presenter {

    private static final int STATE_CODE = 0;

    private ArticleInfoContract.Model mModel;

    public ArticleInfoPresenter() {
        mModel = new ArticleInfoModel();
    }


    @Override
    public void getArticleList(int pageNum) {

        getView().onShowLoading();

        mModel
                .getArticleList(pageNum)
                .subscribe(new RequestCallback<BaseBean<TestBean>>() {
                    @Override
                    protected void onSuccess(BaseBean<TestBean> bean) {
                        // 因为进行了解绑操作，所以需要判断mView是否为空,挺烦的，可以在基类里面使用动态代理进行切面处理
                        getView().onHideLoading();
                        if (bean.errorCode == STATE_CODE) {
                            getView().onSuccess(bean);
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
}
