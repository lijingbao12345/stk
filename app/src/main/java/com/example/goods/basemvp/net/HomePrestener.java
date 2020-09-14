package com.example.goods.basemvp.net;

import com.example.goods.basemvp.base.BasePrestener;
import com.example.goods.basemvp.bean.homebanner.HomeBannerBean;
import com.example.goods.basemvp.bean.homebanner.HomeTestOneBean;
import com.example.goods.basemvp.insertface.Home;
import com.example.goods.common.CommonSubscriber;
import com.example.goods.utils.RxUtils;

//网络请求层  Base了所有网络请求
public class HomePrestener extends BasePrestener<Home.HomeView> implements Home.HomePrestener {


    @Override
    public void HomeBanner() {
        addSubscribe(HttpUtil.getInstance().getInitialApi().getHomeBannerData()
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<HomeBannerBean>(mView) {
            @Override
            public void onNext(HomeBannerBean homeBannerBean) {
                mView.HomeBannerResult(homeBannerBean);
            }
        }));
    }

    @Override
    public void HomeBaseOne() {
        addSubscribe(HttpUtil.getInstance().getOne().getBaseOne().compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<HomeTestOneBean>(mView) {
            @Override
            public void onNext(HomeTestOneBean homeTestOneBean) {
                    mView.HomeBaseOneResult(homeTestOneBean);
            }
        }));
    }
}
