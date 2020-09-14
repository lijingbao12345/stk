package com.example.goods.basemvp.model;

import com.example.goods.basemvp.bean.homebanner.HomeBannerBean;
import com.example.goods.basemvp.bean.homebanner.HomeTestOneBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface BaseInone {
    @GET("home/content")
    Flowable<HomeTestOneBean> getBaseOne();
}
