package com.example.goods.basemvp.insertface;

import com.example.goods.basemvp.bean.homebanner.HomeBannerBean;
import com.example.goods.basemvp.bean.homebanner.HomeTestOneBean;
import com.example.goods.basemvp.prestener.IBasePrestener;
import com.example.goods.basemvp.view.IBaseView;

public interface Home {

    interface HomeView extends IBaseView {
        void HomeBannerResult(HomeBannerBean result);
        void HomeBaseOneResult(HomeTestOneBean result);
    }

    interface HomePrestener extends IBasePrestener<HomeView>{
        void HomeBanner();
        void HomeBaseOne();
    }
}
