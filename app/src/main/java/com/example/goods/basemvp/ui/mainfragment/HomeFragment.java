package com.example.goods.basemvp.ui.mainfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.goods.R;
import com.example.goods.adapter.BrandmanufacturerAdapter;
import com.example.goods.adapter.HomeTestOneAdapter;
import com.example.goods.adapter.PaoMaDengAdapter;
import com.example.goods.adapter.SeckillAdapter;
import com.example.goods.adapter.TitleAdapter;
import com.example.goods.basemvp.app.BaseApp;
import com.example.goods.basemvp.base.BaseAdapter;
import com.example.goods.basemvp.base.BaseFragment;
import com.example.goods.basemvp.bean.homebanner.HomeBannerBean;
import com.example.goods.basemvp.bean.homebanner.HomeTestOneBean;
import com.example.goods.basemvp.insertface.Home;
import com.example.goods.basemvp.net.HomePrestener;

import com.example.goods.common.date.BaseDelegateAdapter;
import com.example.goods.common.date.BaseViewHolder;
import com.example.goods.common.date.GlideImageLoader;
import com.example.goods.databinding.FragmentHomeBinding;

import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<Home.HomePrestener> implements Home.HomeView {
    //控件view
    private FragmentHomeBinding binding;
    //banner图片
    private List<String> bannerlist;

    //第一个商品列表
    private BrandmanufacturerAdapter brandmanufacturerAdapter;

    @Override
    protected View getInflate(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initView() {
//banner
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getActivity());
        DelegateAdapter adapter = new DelegateAdapter(layoutManager, false);
        binding.fragmentHomeRv.setLayoutManager(layoutManager);
        BaseDelegateAdapter bannerAdapter = new BaseDelegateAdapter(new LinearLayoutHelper(), R.layout.vlayout_banner, 1) {
            @Override
            public void onBindViewHolder(@NonNull BaseAdapter.BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                List<Integer> list = new ArrayList<>();
                bannerlist = new ArrayList<>();
                list.add(R.drawable.ic_pause_disable);
                Banner banner = holder.itemView.findViewById(R.id.fragment_home_banner);
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                banner.setImageLoader(new GlideImageLoader());
                banner.setImages(list);
                banner.setBannerAnimation(Transformer.DepthPage);
                banner.isAutoPlay(true);
                banner.setDelayTime(3000);
                banner.setIndicatorGravity(BannerConfig.CENTER);
                banner.start();
                banner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        Toast.makeText(BaseApp.app, "banner点击了" + position, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };


//标题
        BaseDelegateAdapter TitleAdapter = new BaseDelegateAdapter(new GridLayoutHelper(4), R.layout.vlayout_title, 1) {

            private ArrayList<String> strings;

            @Override
            public void onBindViewHolder(@NonNull BaseAdapter.BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                TextView title_one_tv = holder.itemView.findViewById(R.id.title_one_tv);
                ImageView title_img = holder.itemView.findViewById(R.id.title_img);

                strings = new ArrayList<>();
                strings.add("话题");
                strings.add("优选");
                strings.add("特惠");
                strings.add("签到");
                List<Integer> listImg = new ArrayList<>();
                listImg.add(R.mipmap.title_one_tv_img);
                listImg.add(R.mipmap.title_two_img);
                listImg.add(R.mipmap.title_three_img);
                listImg.add(R.mipmap.title_four_img);
                title_one_tv.setText(strings.get(position));

                GlideImageLoader glideImageLoader = new GlideImageLoader();
                glideImageLoader.displayImage(getActivity(), listImg.get(position), title_img);
            }

            @Override
            public int getItemCount() {
                return 4;
            }
        };

        //跑马灯
        BaseDelegateAdapter paomaAdapter = new BaseDelegateAdapter(new LinearLayoutHelper(), R.layout.vlayout_paomadeng, 1) {
            @Override
            public void onBindViewHolder(@NonNull BaseAdapter.BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                MarqueeView marqueeView = holder.itemView.findViewById(R.id.marqueeView);
                List<String> info = new ArrayList<>();
                info.add("雪中悍刀行");
                info.add("剑来");
                info.add("江湖没什么好的，也就酒还行");
                info.add("我的本事都是你教的，今天我都还给你");
                info.add("我以手足换手足，此一生，无悔");
                info.add("白衣擂鼓，拒敌百万");
                info.add("这天下，欠徐家的太多了");
                marqueeView.startWithList(info);
            }
        };

        //品牌
        BaseDelegateAdapter brandAdaptr = new BaseDelegateAdapter(new LinearLayoutHelper(), R.layout.vlayout_brand, 1) {
            @Override
            public void onBindViewHolder(@NonNull BaseAdapter.BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                RecyclerView item_home_testone_rv = holder.itemView.findViewById(R.id.item_home_testone_rv2);
               List<String> testBroad = new ArrayList<>();
                testBroad.add("我是神选中的人，你则么跟我斗？啊？");
                testBroad.add("我是神选中的人，你则么跟我斗？啊？1");
                testBroad.add("我是神选中的人，你则么跟我斗？啊？2");
                testBroad.add("我是神选中的人，你则么跟我斗？啊？3");
                testBroad.add("我是神选中的人，你则么跟我斗？啊？4");
              int soc = 4;
                item_home_testone_rv.setLayoutManager(new GridLayoutManager(getActivity(),2));
                brandmanufacturerAdapter = new BrandmanufacturerAdapter(getActivity(),testBroad);
                item_home_testone_rv.setAdapter(brandmanufacturerAdapter);
            } //品牌
            @Override
            public int getItemCount() {
                return 1;
            }
        };

        BaseDelegateAdapter brandAdaptr2 = new BaseDelegateAdapter(new LinearLayoutHelper(), R.layout.vlayout_brand, 1) {
            @Override
            public void onBindViewHolder(@NonNull BaseAdapter.BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                RecyclerView item_home_testone_rv = holder.itemView.findViewById(R.id.item_home_testone_rv2);
                List<String> testBroad = new ArrayList<>();
                testBroad.add("跳跳虎");
                testBroad.add("大卫天空");
                testBroad.add("三生有幸");
                testBroad.add("性能优化");
                testBroad.add("天下第一");
                int soc = 4;
                item_home_testone_rv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                brandmanufacturerAdapter = new BrandmanufacturerAdapter(getActivity(), testBroad);
                item_home_testone_rv.setAdapter(brandmanufacturerAdapter);
            }
        };

        adapter.addAdapter(bannerAdapter);
        adapter.addAdapter(TitleAdapter);
        adapter.addAdapter(paomaAdapter);
        adapter.addAdapter(brandAdaptr);
        adapter.addAdapter(brandAdaptr2);
        binding.fragmentHomeRv.setAdapter(adapter);
        /*

//制造商
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        homeTestOneAdapter = new HomeTestOneAdapter(getActivity(), linearLayoutHelper, 1);
        binding.fragmentHomeRv.setAdapter(homeTestOneAdapter);
        delegateAdapter.addAdapter(homeTestOneAdapter);

        //秒杀专区
        LinearLayoutHelper linearLayoutHelper1 = new LinearLayoutHelper();
        SeckillAdapter seckillAdapter = new SeckillAdapter(getActivity(), linearLayoutHelper1, 1);
        binding.fragmentHomeRv.setAdapter(seckillAdapter);
        delegateAdapter.addAdapter(seckillAdapter);
*/
      /*  //秒杀
        BaseDelegateAdapter seckillAdapter = new BaseDelegateAdapter(new LinearLayoutHelper(), R.layout.vlayout_seckill, 1) {
            @Override
            public void onBindViewHolder(@NonNull BaseAdapter.BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);

            }
        };*/

        //添加所有适配器，是按照顺序添加


       /* StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper(3, 0);

        binding.fragmentHomeRv.setAdapter();*/

//包裹所有适配器的适配器
        /*    binding.fragmentHomeRv.setAdapter(delegateAdapter);*/


    }

    @Override
    protected Home.HomePrestener createPresenter() {
        return new HomePrestener();
    }

    @Override
    protected void initData() {
        mPresenter.HomeBanner();
        mPresenter.HomeBaseOne();
    }

    @Override
    public void HomeBannerResult(HomeBannerBean result) {
        bannerlist = new ArrayList<>();
        List<HomeBannerBean.DataBean.AdvertiseListBean> advertiseList = result.getData().getAdvertiseList();

        for (int i = 0; i < advertiseList.size(); i++) {
            bannerlist.add(advertiseList.get(i).getPic());
        }
        initBannerData();


    }

    @Override
    public void HomeBaseOneResult(HomeTestOneBean result) {
        List<HomeTestOneBean.DataBean.BrandListBean> brandList = result.getData().getBrandList();
       /* brandmanufacturerAdapter.setBeanList(brandList);*/

    }

    private void initBannerData() {

    }
}
