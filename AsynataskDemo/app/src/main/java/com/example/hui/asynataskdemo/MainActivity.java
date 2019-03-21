package com.example.hui.asynataskdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button download = null;
    private TextView finish_tv = null;
    private ProgressBar progressBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        download = (Button)findViewById(R.id.download);
        finish_tv = (TextView)findViewById(R.id.finish_tv);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);


        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadTask downloadTask = new DownloadTask(finish_tv, progressBar);
                downloadTask.execute(100);
            }
        });
    }
}
