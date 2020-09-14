package com.example.goods.basemvp.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter {

    protected List<T> mData = new ArrayList<>();
    protected Context context;

    public BaseAdapter(Context context) {
        this.context = context;
    }

    public void addData(List<T> mData) {
        if (mData != null && mData.size() > 0) {
            this.mData.clear();
            this.mData.addAll(mData);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(getLayout(), parent, false);
        final BaseViewHolder baseViewHolder = new BaseViewHolder(view);
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickItemListener != null) {
                    //baseViewHolder.getLayoutPosition()  获取当前条目的下标
                    onClickItemListener.onClickItem(baseViewHolder.getLayoutPosition());
                }
            }
        });
        return baseViewHolder;
    }

    protected abstract int getLayout();

    //上拉刷新
    protected void onRefresh(List<T> mData) {
        this.mData.clear();
        this.mData.addAll(mData);
        notifyDataSetChanged();
    }

    //下拉加载
    protected void onLoadMore(List<T> mData) {
        this.mData.addAll(mData);
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BaseViewHolder baseViewHolder = (BaseViewHolder) holder;
        //当前条目的数据
        T t = mData.get(position);
        bindData(baseViewHolder, t, position);
    }

    protected abstract void bindData(BaseViewHolder baseViewHolder, T t, int position);

    @Override
    public int getItemCount() {
        return mData.size();
    }

    OnClickItemListener onClickItemListener;

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    public interface OnClickItemListener {
        void onClickItem(int position);
    }

    public static class BaseViewHolder extends RecyclerView.ViewHolder {
        //类似于HashMap的集合 key值只能是int 类型
        SparseArray sparseArray;

        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
            sparseArray = new SparseArray();
        }

        //创建方法来找布局
        public View getView(int id) {
            //先判断容器中是否有该布局
            View view = (View) sparseArray.get(id);
            if (view == null) {
                //如果没有就找到该布局并把它添加进容器中
                view = itemView.findViewById(id);
                sparseArray.append(id, view);
            }
            return view;
        }
    }
}
