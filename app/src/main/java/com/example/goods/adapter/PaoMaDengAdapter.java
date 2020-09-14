package com.example.goods.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.goods.R;
import com.example.goods.databinding.ItemPaomaodengBinding;
import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

import static com.example.goods.common.CrashHandler.TAG;

public class PaoMaDengAdapter extends DelegateAdapter.Adapter<PaoMaDengAdapter.ViewHolder> {
    Context context;
    SingleLayoutHelper singleLayoutHelper;
    int count = 1;
    private MarqueeView mvMultiText5;
    private  Button but;

    public PaoMaDengAdapter(Context context, SingleLayoutHelper singleLayoutHelper, int count) {
        this.context = context;
        this.singleLayoutHelper = singleLayoutHelper;
        this.count = count;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPaomaodengBinding binding = ItemPaomaodengBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        List<String> datas = new ArrayList<>();
        datas.add("11111111111111");
        datas.add("22222222222222");
   /*     datas.add("33333333333333");
        datas.add("44444444444444");
        datas.add("55555555555555");
        datas.add("66666666666666");*/
        mvMultiText5.startWithList(datas);
        mvMultiText5.startWithList(datas, R.anim.anim_bottom_in, R.anim.anim_top_out);
      /*  String notice = "空调洗衣机大甩卖，先到先得";
        mvMultiText5.startWithText(notice);
        // 在代码里设置自己的动画
        mvMultiText5.startWithText(notice, R.anim.anim_bottom_in, R.anim.anim_top_out);*/


    }

    @Override
    public int getItemCount() {
        return count;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull ItemPaomaodengBinding itemView) {
            super(itemView.getRoot());
            mvMultiText5 = itemView.mvMultiText5;
            but = itemView.but;
        }
    }
}
