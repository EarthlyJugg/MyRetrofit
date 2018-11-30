package com.lingtao.recyclerlibrary.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lingtao.recyclerlibrary.R;

public abstract class RvBaseCell implements Cell {


    @Override
    public void releaseResource() {
        // do nothing
        // 如果有需要回收的资源，子类自己实现
    }

}
