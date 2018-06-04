package com.sx.mvp.mvp.base;

import com.sx.mvp.bean.ArticleBean;
import com.sx.mvp.bean.BaseResponse;

/**
 * @Author sunxin
 * @Date 2018/6/3 20:44
 * @Description View的基类
 */
public interface IBaseView {
    /**
     * 显示加载中
     */
    void onShowLoading();

    /**
     * 隐藏进度
     */
    void onHideLoading();

    /**
     * 错误
     *
     * @param errorMsg
     */
    void onError(String errorMsg);

    /**
     * 网络错误
     */
    void onNetWorkError();

    /**
     * 请求成功
     *
     * @param bean
     */
    void onSuccess(BaseResponse<ArticleBean> bean);
}
