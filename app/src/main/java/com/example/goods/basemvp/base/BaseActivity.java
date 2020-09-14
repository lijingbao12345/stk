package com.example.goods.basemvp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.goods.R;
import com.example.goods.basemvp.prestener.IBasePrestener;
import com.example.goods.basemvp.view.IBaseView;
import com.example.goods.databinding.ActivityMainBinding;

public abstract class BaseActivity<P extends IBasePrestener> extends AppCompatActivity implements IBaseView {
    protected P mPrestener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //视图绑定。
        setContentView(initLayout());

        initView();

        mPrestener = setPrestener();
        //p层不为空绑定view，在data方法中引用mPrestener
        if (mPrestener != null) {
            mPrestener.attachView(this);
            initData();
        }

    }


    protected abstract View initLayout();

    protected abstract P setPrestener();

    protected abstract void initView();

    protected abstract void initData();




    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mPrestener != null) {
            mPrestener.detachView();
        }
    }
}
