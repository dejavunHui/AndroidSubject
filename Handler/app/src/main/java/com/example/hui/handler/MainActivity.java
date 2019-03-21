package com.example.hui.handler;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.os.Handler;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView random_tv = null;

    private Handler handler = null;//第一步,声明一个Handler对象
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random_tv = (TextView)findViewById(R.id.random_tv);
        random_tv.setText("产生的随机数:"+ Math.random());

        handler = new Handler(){
            public void handleMessage(Message message){
                if(message.what == 0x11){
                    random_tv.setText("产生的随机数:"+Math.random());
                }
            }
        };//实例化Handler对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Message message = new Message();
                        message.what = 0x11;
                        handler.sendMessage(message);
                        Thread.sleep(2000);

                    }
                }catch (InterruptedException e){
                    
                }
            }
        }).start();
    }
}
