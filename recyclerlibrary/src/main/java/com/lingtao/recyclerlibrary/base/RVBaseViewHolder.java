package com.lingtao.recyclerlibrary.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RVBaseViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> views;
    private View mItemView;

    public RVBaseViewHolder(@NonNull View itemView) {
        super(itemView);
        this.mItemView = itemView;
        views = new SparseArray<>();
    }


    public View getmItemView() {
        return mItemView;
    }

    public View getView(int res) {
        return retrieveView(res);
    }

    public TextView getTextView(int resId) {
        return retrieveView(resId);
    }

    public ImageView getImageView(int resId) {
        return retrieveView(resId);
    }

    public Button getButton(int resId) {
        return retrieveView(resId);
    }

    protected <V extends View> V retrieveView(int resId) {
        View view = views.get(resId);
        if (view == null) {
            view = mItemView.findViewById(resId);
            views.put(resId, view);
        }
        return (V) view;
    }

    public void setText(int resId, CharSequence text) {
        getTextView(resId).setText(text);
    }

    public void setText(int resId, int strId) {
        getTextView(resId).setText(strId);
    }


}
