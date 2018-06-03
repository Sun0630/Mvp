package com.sx.mvp.mvp.article;

import com.sx.mvp.bean.BaseBean;
import com.sx.mvp.bean.TestBean;
import com.sx.mvp.http.RetrofitManager;
import com.sx.mvp.http.RxSchedulers;
import com.sx.mvp.http.apiservice.ApiService;

import io.reactivex.Observable;

/**
 * @Author sunxin
 * @Date 2018/6/3 18:00
 * @Description M 层
 */
public class ArticleInfoModel implements ArticleInfoContract.Model {

    @Override
    public Observable<BaseBean<TestBean>> getArticleList(int pageNum) {

        return  RetrofitManager
                .getRetrofit()
                .create(ApiService.class)
                .getContent(pageNum)
                .compose(RxSchedulers.applySchedulers());
    }
}
