package com.example.goods.utils;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goods.basemvp.app.BaseApp;
import com.example.goods.databinding.ActivityMainBinding;

public class BaseAdapterTest extends RecyclerView.Adapter<BaseAdapterTest.ViewHolder> {
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ActivityMainBinding.inflate(LayoutInflater.from(BaseApp.app),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ActivityMainBinding itemView = holder.itemView;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final com.example.goods.databinding.ActivityMainBinding itemView;

        public ViewHolder(@NonNull ActivityMainBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
    }
}
