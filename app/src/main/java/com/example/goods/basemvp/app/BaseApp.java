package com.example.goods.basemvp.app;

import android.app.Application;
import android.content.Context;

public class BaseApp extends Application {

    public static Context app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        com.example.goods.common.CrashHandler.getInstance().init(this);
    }
}
