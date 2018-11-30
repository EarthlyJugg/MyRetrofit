package com.lingtao.myretrofit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;

import com.lingtao.core.app.ProjectInit;
import com.lingtao.myretrofit.fragment.HomeFragment;
import com.lingtao.myretrofit.fragment.TestFragment;
import com.lingtao.recyclerlibrary.widget.RefreshableView;


public class MainActivity extends AppCompatActivity {

    private Fragment homeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        homeFragment = new HomeFragment();
//        homeFragment = new TestFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, homeFragment).commit();



//        refreshableView = (RefreshableView) findViewById(R.id.refreshable_view);
//        listView = (RecyclerView) findViewById(R.id.list_view);
//        List<LoadingCell> li = new LinkedList<>();
////        for (int i = 0; i < 10; i++) {
////            li.add(new News());
////        }
//        li.add(new LoadingCell());
//        listView.setLayoutManager(new LinearLayoutManager(this));
////        adapter = new RecyclerAdater(li);
//        RvBaseAdapter<LoadingCell> adapter = new RvBaseAdapter() {
//            @Override
//            protected void onViewHolderBound(RVBaseViewHolder holder, int position) {
//
//            }
//        };
//        adapter.setData(li);
//        listView.setAdapter(adapter);
//        refreshableView.setOnRefreshListener(new RefreshableView.PullToRefreshListener() {
//            @Override
//            public void onRefresh() {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                refreshableView.finishRefreshing();
//            }
//        }, 0);


    }

    public void delItem(View view) {
//        homeFragment.del();
    }

    public void addItem(View view) {
//        homeFragment.add();
    }
}
