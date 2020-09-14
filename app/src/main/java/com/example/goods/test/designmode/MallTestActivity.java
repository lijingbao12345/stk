package com.example.goods.test.designmode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.alibaba.android.vlayout.layout.FloatLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.example.goods.R;
import com.example.goods.basemvp.base.BaseActivity;
import com.example.goods.basemvp.prestener.IBasePrestener;
import com.example.goods.databinding.ActivityMallTestBinding;

import java.util.ArrayList;

public class MallTestActivity extends BaseActivity {

    private ActivityMallTestBinding binding;

    @Override
    protected View initLayout() {
        binding = ActivityMallTestBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    protected IBasePrestener setPrestener() {
        return null;
    }

    @Override
    protected void initView() {
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(this);
        // 创建VirtualLayoutManager对象
        // 同时内部会创建一个LayoutHelperFinder对象，用来后续的LayoutHelper查找
        binding.malltestRv.setLayoutManager(virtualLayoutManager);
        // 将VirtualLayoutManager绑定到recyclerView
        // 设置组件复用回收池
        //设置缓存view个数(当视图中view的个数很多时，设置合理的缓存大小，防止来回滚动时重新创建 View)
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        binding.malltestRv.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 20);

        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
        binding.malltestRv.setAdapter(delegateAdapter);

        ArrayList<DelegateAdapter.Adapter> adapters = new ArrayList<>();
        adapters.add(new MyAdapter(MallTestActivity.this, new GridLayoutHelper(3), 10));
        //固定布局，可让item固定在屏幕某个位置
        //默认左上角，x，y偏移20
        adapters.add(new MyAdapter(this, new FixLayoutHelper(20, 20), 1));
        //设置到右上角，xy各自偏移20
        adapters.add(new MyAdapter(this, new FixLayoutHelper(FixLayoutHelper.TOP_RIGHT, 20, 20), 1));

        //浮动布局，任意拖动item
        //指定item宽高
        VirtualLayoutManager.LayoutParams layoutParams = new VirtualLayoutManager.LayoutParams(150, 150);
        adapters.add(new MyAdapter(this,new FloatLayoutHelper(),1,layoutParams));

        //1行显示多列item

        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        columnLayoutHelper.setWeights(new float[]{40.0f,30.0f,30.0f});  //设置比例 4：3:3
        adapters.add(new MyAdapter(this,columnLayoutHelper,3));


        //单行布局，用来显示广告轮播,或者其他需要单独显示的item
        adapters.add(new MyAdapter(this,new SingleLayoutHelper(),1));

        //一拖N布局（N最大为4）,即OnePlusNLayoutHelper最多只能有5个item。
        OnePlusNLayoutHelper onePlusNLayoutHelper = new OnePlusNLayoutHelper();
        onePlusNLayoutHelper.setColWeights(new float[]{10f});  //左边一栏占10%
        onePlusNLayoutHelper.setRowWeight(30f); //右边上部分一栏占30%
        adapters.add(new MyAdapter(this,onePlusNLayoutHelper,5));

        //item吸附到顶部
        adapters.add(new MyAdapter(this,new StickyLayoutHelper(true),1));
        adapters.add(new MyAdapter(this,new StickyLayoutHelper(false),1));


        //瀑布流布局
        StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper(3, 0);
        adapters.add(new MyAdapter(this,staggeredGridLayoutHelper,25));




        delegateAdapter.addAdapters(adapters);


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