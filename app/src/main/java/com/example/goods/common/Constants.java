package com.example.goods.common;


import com.example.goods.basemvp.app.BaseApp;


import java.io.File;
//常量类
public class Constants {

    public static final String Base_WanUrl = "http://169.254.111.136:8085/";
    public static final String Base_One = "http://169.254.111.136:8085/";
    public static final String BASE_OWNUrl="http://cdwan.cn:9001/";
    public static final String BASE_UpLoadUrl="http://yun918.cn/study/public/";

//必须注册baseapp
    public static final String PATH_DATA = BaseApp.app.getExternalCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/mall";

    public static final int DATA_SUCCESS = 100;

    //图片集合以及下标
    public static int INDEX_IMG = -1;


}
