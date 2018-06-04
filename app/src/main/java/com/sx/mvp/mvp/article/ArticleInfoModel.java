package com.sx.mvp.mvp.article;

import com.sx.mvp.bean.ArticleBean;
import com.sx.mvp.bean.BannerBean;
import com.sx.mvp.bean.BaseResponse;
import com.sx.mvp.http.RetrofitManager;
import com.sx.mvp.http.RxUtils;
import com.sx.mvp.http.apiservice.ApiService;

import java.util.List;

import io.reactivex.Observable;

/**
 * @Author sunxin
 * @Date 2018/6/3 18:00
 * @Description M 层
 */
public class ArticleInfoModel implements ArticleInfoContract.Model {

    @Override
    public Observable<BaseResponse<ArticleBean>> getArticleList(int pageNum) {

        return RetrofitManager
                .getRetrofit()
                .create(ApiService.class)
                .getContent(pageNum)
                .compose(RxUtils.applySchedulers());
    }

    @Override
    public Observable<BaseResponse<List<BannerBean>>> getBanners() {
        return RetrofitManager
                .getRetrofit()
                .create(ApiService.class)
                .getBanners()
                .compose(RxUtils.applySchedulers());
    }


}
