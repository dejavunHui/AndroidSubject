package com.example.hui.asynataskdemo;

import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DownloadTask extends AsyncTask {

    TextView finish_tv = null;
    ProgressBar progressBar = null;


    public DownloadTask() {
    }

    public DownloadTask(TextView finish_tv, ProgressBar progressBar) {
        this.finish_tv = finish_tv;
        this.progressBar = progressBar;
    }

    public TextView getFinish_tv() {
        return finish_tv;
    }

    public void setFinish_tv(TextView finish_tv) {
        this.finish_tv = finish_tv;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    protected String doInBackground(Object[] objects){
        try {
            for (int i = 0; i <= 100; i++) {
                publishProgress(i);
                Thread.sleep((int)objects[0]);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "下载完毕!";
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        progressBar.setProgress((Integer) values[0]);
        progressBar.setVisibility(ProgressBar.VISIBLE);
        finish_tv.setText("当前完成任务的:"+(int)values[0] +"%");
    }

    @Override
    protected void onPostExecute(Object o) {
        finish_tv.setText((String) o);
        finish_tv.setTextColor(Color.RED);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }
}
