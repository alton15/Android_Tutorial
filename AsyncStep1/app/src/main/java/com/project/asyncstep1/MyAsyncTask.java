package com.project.asyncstep1;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MyAsyncTask extends AsyncTask<String, Integer, String> {

    private WeakReference<TextView> mTextView;
    MyAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }

    @Override
    protected String doInBackground(String... strings) {
        int s = 10000;
        try {
            Thread.sleep(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s + " 밀리초 후에 깬다.";
    }

    @Override
    protected void onPostExecute(String s) {
        mTextView.get().setText(s);
    }
}
