package com.sx.mvp.mvp.article;

import com.sx.mvp.bean.ArticleBean;
import com.sx.mvp.bean.BannerBean;
import com.sx.mvp.bean.BaseResponse;
import com.sx.mvp.mvp.base.IBaseView;

import java.util.List;

import io.reactivex.Observable;

/**
 * @Author sunxin
 * @Date 2018/6/3 17:54
 * @Description 契约类
 */
public interface ArticleInfoContract {

    interface View extends IBaseView {
        /**
         * 显示文章列表
         *
         * @param bean
         */
        void showArticleList(BaseResponse<ArticleBean> bean);


        /**
         * 显示banner数据
         *
         * @param bannerBean
         */
        void showBanner(BaseResponse<List<BannerBean>> bannerBean);
    }

    interface Model {
        /**
         * 获取首页文章列表
         *
         * @param pageNum
         * @return
         */
        Observable<BaseResponse<ArticleBean>> getArticleList(int pageNum);

        /**
         * 获取首页banner
         * @return
         */
        Observable<BaseResponse<List<BannerBean>>> getBanners();
    }

    interface Presenter{
        /**
         * 获取首页文章列表
         *
         * @param pageNum
         */
        void getArticleList(int pageNum);

        /**
         * 获取首页banner
         */
        void getBanners();
    }
}
