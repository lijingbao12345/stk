package com.example.goods.basemvp.prestener;

import com.example.goods.basemvp.view.IBaseView;
//p层持有v层引用
public interface IBasePrestener<V extends IBaseView> {
    void attachView(V view);

    void detachView();

}
