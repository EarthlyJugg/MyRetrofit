package com.lingtao.recyclerlibrary.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.lingtao.recyclerlibrary.cell.LoadingCell;

import java.util.ArrayList;
import java.util.List;

public abstract class RvBaseAdapter<C extends Cell> extends RecyclerView.Adapter<RVBaseViewHolder> {

    protected List<C> mData;

    public RvBaseAdapter() {
        mData = new ArrayList<>();
    }

    public void setData(List<C> list) {
       addAll(list);
    }

    public void refreshData(List<C> list) {
        mData.clear();
        setData(list);
    }

    @NonNull
    @Override
    public RVBaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        for (int i = 0; i < mData.size(); i++) {
            if (mData.get(i).getItemType() == viewType) {
                return mData.get(i).onCreateViewHolder(viewGroup, viewType);
            }
        }
        throw new RuntimeException("wrong viewType");
    }

    @Override
    public void onBindViewHolder(@NonNull RVBaseViewHolder rvBaseViewHolder, int i) {
        onViewHolderBound(rvBaseViewHolder, i);
        C c = mData.get(i);
        c.onBindViewHolder(rvBaseViewHolder, i);
    }


    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getItemType();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull RVBaseViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        int position = holder.getAdapterPosition();
        //越界检查
        if (position < 0 || position >= mData.size()) {
            return;
        }
        mData.get(position).releaseResource();
    }

    public void add(C cell) {
        mData.add(cell);
        int index = mData.indexOf(cell);
        notifyItemChanged(index);
    }

    public void add(int index, C c) {
        mData.add(index, c);
        notifyItemChanged(index);
    }

    public void remove(C cell) {
        int index = mData.indexOf(cell);
        remove(index);
    }

    public void remove(int index) {
        mData.remove(index);
        notifyItemRemoved(index);
    }

    /**
     * @param start 从什么位置开始
     * @param count 删除的数量
     */
    public void remove(int start, int count) {
        if ((start + count) > mData.size()) {
            throw new RuntimeException("删除数量大于总数据大小");
        }
        mData.subList(start, start + count).clear();
        notifyItemRangeRemoved(start, count);

    }

    public void addAll(List<C> cells) {
        if (cells == null || cells.size() == 0) {
            return;
        }
        mData.addAll(cells);
        notifyItemRangeChanged(mData.size() - cells.size(), mData.size());
    }

    public void addAll(int index, List<C> cells) {
        if (cells == null || cells.size() == 0) {
            return;
        }
        mData.addAll(index, cells);
        notifyItemRangeChanged(index, index + cells.size());
    }


    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }

    private void checkIndexOut(int start) {
        if (start < 0 || start > mData.size()) {
            throw new RuntimeException("start 取值错误");
        }
    }

    /**
     * 如果子类需要在onBindViewHolder 回调的时候做的操作可以在这个方法里做
     *
     * @param holder
     * @param position
     */
    protected abstract void onViewHolderBound(RVBaseViewHolder holder, int position);
}
