package com.lingtao.recyclerlibrary.cell;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.lingtao.recyclerlibrary.R;
import com.lingtao.recyclerlibrary.base.RVBaseViewHolder;
import com.lingtao.recyclerlibrary.base.RVSimpleAdapter;
import com.lingtao.recyclerlibrary.util.Utils;

public class LoadMoreCell extends RVAbsStateCell {
    public static final int mDefaultHeight = 56;//dp

    @Override
    public int getItemType() {
        return RVSimpleAdapter.LOAD_MORE_TYPE;
    }


    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {

    }

    @Override
    protected View getDefaultView(Context context) {
        // 设置LoadMore View显示的默认高度
        setHeight(Utils.dpToPx(context, mDefaultHeight));
        return LayoutInflater.from(context).inflate(R.layout.rv_load_more_layout, null);
    }
}
