package com.example.goods.common.vidioutils;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VideoItemDecoration3 extends RecyclerView.ItemDecoration {

    private int space; //item之间的间距

    public void setSpace(int value){
        space = value;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        //不是第一个的格子都设一个左边和底部的间距
        //由于每行都只有2个，所以第一个都是2的倍数，把左边距设为0
        //左边的纵列item的左右两边都有空隙
        if (parent.getChildLayoutPosition(view) % 4==0) {
            outRect.left = space;
            outRect.right = space;
        }else if(parent.getChildLayoutPosition(view) % 4==1){
            //右边的纵列左边空隙为0 右有space空隙
            outRect.right = space;
        }else if(parent.getChildLayoutPosition(view) % 4==2){
            outRect.right = space;
        }else{
            outRect.right = space;
        }
        outRect.top = space;
    }
}
