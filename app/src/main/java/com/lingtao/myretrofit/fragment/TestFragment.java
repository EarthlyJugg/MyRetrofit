package com.lingtao.myretrofit.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.lingtao.myretrofit.R;

public class TestFragment extends Fragment {


    private TextView tv;
    private Button btn;
    private Button btn1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);

        initView(view);
        initListener();

        return view;
    }

    private void initView(View view) {
        tv = (TextView) view.findViewById(R.id.tv);
        btn = (Button) view.findViewById(R.id.btn);
        btn1 = (Button) view.findViewById(R.id.btn1);

    }

    private void initListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTask = new MyAsyncTask(tv);
                myTask.execute();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTask.setStop(true);
            }
        });
    }

    private MyAsyncTask myTask;


    private class MyAsyncTask extends AsyncTask<String, Integer, Void> {

        private TextView textView;
        private String[] str = {"First advertisement", "Second advertisement"};
        private int n = 0;
        private boolean stop = false;

        public MyAsyncTask(TextView textView) {
            this.textView = textView;
        }

        public void setStop(boolean stop) {
            this.stop = stop;
        }

        @Override
        protected Void doInBackground(String... params) {
            Log.d("Tag", "doInBackgroud");
            while (!stop) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /**
                 * n就是传入下面onProgressUpdate 的参数
                 * publishProgress是跨线程的，
                 */
                publishProgress(n);
                n++;
                Log.i("Tag", "publishProgress" + n);

            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.i("Tag", "n=" + values[0]);
            textView.setText(n + str[values[0] % 2]);
            // textView.setText("noThing");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            textView.setText("广告结束");
        }
    }

}
