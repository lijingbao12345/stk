package com.example.goods.common;

import android.text.TextUtils;
import android.util.Log;

//其封装的是包裹网络请求比如rxjava的方法

import com.example.goods.basemvp.view.IBaseView;

import io.reactivex.subscribers.ResourceSubscriber;

public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {

    private IBaseView mView;
    private String errorMsg;
    private boolean isShowErrorState = false;

    protected CommonSubscriber(IBaseView view) {
        mView = view;
    }

    protected CommonSubscriber(IBaseView view, String emsg) {
        mView = view;
        errorMsg = emsg;
    }

    protected CommonSubscriber(IBaseView view, boolean isError) {
        mView = view;
        isShowErrorState = isError;
    }

    protected CommonSubscriber(IBaseView view, String emsg, boolean isError) {
        mView = view;
        errorMsg = emsg;
        isShowErrorState = isError;
    }
//所有网络请求都要经过这个类，可以直接debog寻找
    @Override
    public void onError(Throwable t) {
        //LoadingUtil.getInstance().hideLoading();
        if (mView == null) return;
        if (errorMsg != null && TextUtils.isEmpty(errorMsg)) {
            Log.d("sss", "onError: "+t.getMessage());
            mView.showTips(errorMsg);
        }
    }

    @Override
    public void onComplete() {
        //LoadingUtil.getInstance().hideLoading();
        //mView.showLoading(View.GONE);
    }
}
