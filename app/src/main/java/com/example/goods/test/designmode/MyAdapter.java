package com.example.goods.test.designmode;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.goods.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends DelegateAdapter.Adapter<MyAdapter.MainViewHolder> {
    Context context;
    private LayoutHelper layoutHelper;
    private int count = 0;
    private VirtualLayoutManager.LayoutParams params;

    public MyAdapter(Context context, LayoutHelper helper, int count) {
        this(context, helper, count,
                new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
    }

    public MyAdapter(Context context, LayoutHelper layoutHelper, int count, VirtualLayoutManager.LayoutParams params) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.count = count;
        this.params = params;
    }

// 比系统自带的RecyclerAdapter需要多重载onCreateLayoutHelper（）

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_malltest, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
holder.itemView.setLayoutParams(new VirtualLayoutManager.LayoutParams(params));
    }

    @Override
    protected void onBindViewHolderWithOffset(MainViewHolder holder, int position, int offsetTotal) {
        super.onBindViewHolderWithOffset(holder, position, offsetTotal);
        ((TextView) holder.itemView.findViewById(R.id.textView4)).setText(Integer.toString(offsetTotal));

    }

    @Override
    public int getItemCount() {
        return count;
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);


        }
    }


    // 其余写法与复写系统自带的Adapter相同
}
