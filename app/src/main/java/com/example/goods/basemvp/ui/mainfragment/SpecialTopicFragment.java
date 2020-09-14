package com.example.goods.basemvp.ui.mainfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.goods.R;
import com.example.goods.basemvp.base.BaseFragment;
import com.example.goods.basemvp.prestener.IBasePrestener;

public class SpecialTopicFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_specialtopic, container, false);
        return inflate;

    }
}
