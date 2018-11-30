package com.lingtao.recyclerlibrary.cell;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.lingtao.recyclerlibrary.R;
import com.lingtao.recyclerlibrary.base.RVBaseViewHolder;
import com.lingtao.recyclerlibrary.base.RVSimpleAdapter;

public class LoadingCell extends RVAbsStateCell {

    @Override
    public int getItemType() {
        return RVSimpleAdapter.LOADING_TYPE;
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {

    }

    @Override
    protected View getDefaultView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.rv_loading_layout,null);
    }
}
