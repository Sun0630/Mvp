package com.sx.mvp.http.apiservice;


import com.sx.mvp.bean.ArticleBean;
import com.sx.mvp.bean.BannerBean;
import com.sx.mvp.bean.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @Author sunxin
 * @Date 2018/5/23 0023 上午 10:54
 * @Description 测试
 */

public interface ApiService {

    /**
     * 获取内容
     *
     * @param pageNum
     * @return
     */
    @GET("article/list/{pageNum}/json")
    Observable<BaseResponse<ArticleBean>> getContent(@Path("pageNum") int pageNum);


    /**
     * 获取首页轮播图
     * @return
     */
    @GET("banner/json")
    Observable<BaseResponse<List<BannerBean>>> getBanners();


}
