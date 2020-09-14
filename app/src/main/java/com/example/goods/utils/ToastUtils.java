package com.example.goods.utils;

import android.widget.Toast;

import com.example.goods.basemvp.app.BaseApp;
//吐丝

public class ToastUtils {

    public static void onShortToast(String msg) {
        Toast.makeText(BaseApp.app, msg, Toast.LENGTH_SHORT).show();
    }

    public static void onLongToast(String msg) {
        Toast.makeText(BaseApp.app, msg, Toast.LENGTH_LONG).show();
    }
}
