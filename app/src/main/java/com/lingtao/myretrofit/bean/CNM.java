package com.lingtao.myretrofit.bean;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lingtao.myretrofit.R;
import com.lingtao.recyclerlibrary.base.RVBaseViewHolder;
import com.lingtao.recyclerlibrary.base.RvBaseCell;

public class CNM extends RvBaseCell {


    private int anInt;

    public CNM(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public int getItemType() {
        return 0;
    }

    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_loading_layout2, null);
        return new RVBaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {

        holder.setText(R.id.text, "你是煞笔吗+" + anInt);

    }
}
