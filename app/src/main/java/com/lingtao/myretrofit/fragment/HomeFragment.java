package com.lingtao.myretrofit.fragment;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.lingtao.myretrofit.bean.CNM;
import com.lingtao.recyclerlibrary.fragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends AbsBaseFragment {

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    List<CNM> list = new ArrayList<>();
                    for (int i = 0; i < 15; i++) {
                        list.add(new CNM(i));
                    }
                    mBaseAdapter.hideLoading();
                    mBaseAdapter.setData(list);
                    break;
                case 1:
//                    setLoadMoreFinish();
                    int itemCount = mBaseAdapter.getItemCount();
                    List<CNM> list2 = new ArrayList<>();
                    for (int i = itemCount; i < itemCount+10; i++) {
                        list2.add(new CNM(i));
                    }
                    mBaseAdapter.hideLoadMore();
                    mBaseAdapter.setData(list2);
                    break;
            }
        }

    };

    @Override
    public void onRecyclerViewInitialized() {
        mBaseAdapter.showLoading();
        handler.sendEmptyMessageDelayed(0, 2000);



    }

    @Override
    public void onPullRefresh() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mSwipeRefreshLayout.finishRefreshing();

    }


    @Override
    public void onLoadMore() {
        Log.d("nongyulian", "来了,老弟");
        handler.sendEmptyMessageDelayed(1, 2000);

    }

    @Override
    public View addToolbar() {
//        View view = LayoutInflater.from(getContext()).inflate(R.layout.pull_to_refresh, null);
//        return view;
        return null;
    }
}
