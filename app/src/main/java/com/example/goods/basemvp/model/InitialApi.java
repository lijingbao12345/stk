package com.example.goods.basemvp.model;

import com.example.goods.basemvp.bean.homebanner.HomeBannerBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/*
 * 最初的api
 * */
public interface InitialApi {
    //HomeBannerBean   轮播图
    @GET("home/content")
    Flowable<HomeBannerBean> getHomeBannerData(); //HomeBannerBean   轮播图



}
