package com.lingtao.recyclerlibrary.cell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.lingtao.recyclerlibrary.R;
import com.lingtao.recyclerlibrary.base.RVBaseViewHolder;
import com.lingtao.recyclerlibrary.base.RVSimpleAdapter;


/**
 * Created by zhouwei on 17/1/23.
 */

public class ErrorCell extends RVAbsStateCell {

    @Override
    public int getItemType() {
        return RVSimpleAdapter.ERROR_TYPE;
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {

    }

    @Override
    protected View getDefaultView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.rv_error_layout,null);
    }
}
