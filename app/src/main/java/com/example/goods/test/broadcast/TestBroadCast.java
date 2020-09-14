package com.example.goods.test.broadcast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.goods.R;
import com.example.goods.basemvp.base.BaseActivity;
import com.example.goods.basemvp.prestener.IBasePrestener;
import com.example.goods.databinding.ActivityTestBroadCastBinding;

public class TestBroadCast extends BaseActivity {

    private ActivityTestBroadCastBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestBroadCastBinding.inflate(getLayoutInflater());
        initView();

       /* inflate.testbroadTextView.setText();*/
    }

    @Override
    protected View initLayout() {
        return binding.getRoot();
    }

    @Override
    protected IBasePrestener setPrestener() {
        return null;
    }

    @Override
    protected void initView() {
       /* inflate.testbroadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

    }

    @Override
    protected void initData() {

    }


    @Override
    public void showTips(String tips) {

    }

    @Override
    public void showLoading(int visible) {

    }
}