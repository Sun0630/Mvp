package com.sx.mvp.mvp.article;

import com.sx.mvp.bean.BaseBean;
import com.sx.mvp.bean.TestBean;
import com.sx.mvp.mvp.base.IBaseView;

import io.reactivex.Observable;

/**
 * @Author sunxin
 * @Date 2018/6/3 17:54
 * @Description 契约类
 */
public interface ArticleInfoContract {

     interface View extends IBaseView{
        void onShowLoading();
        void onHideLoading();
        void onError(String errorMsg);
        void onNetWorkError();
        void onSuccess(BaseBean<TestBean> bean);
    }

    interface Model{
        Observable<BaseBean<TestBean>> getArticleList(int pageNum);
    }

    interface Presenter{
        void getArticleList(int pageNum);
    }
}
