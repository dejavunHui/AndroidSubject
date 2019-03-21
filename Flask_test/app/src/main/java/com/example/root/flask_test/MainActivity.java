package com.example.root.flask_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.push).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        pushInformation("http://0.0.0.0:5000/video","女儿国");
                    }
                }).start();
            }
        });
    }

    private void pushInformation(String actionUrl,String name){
        String end = "\n";
        String boundary = "*********";
        String twoHyphens = "--";

        try{
            URL url = new URL(actionUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            //允许Input，Output，不适用Cache
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setUseCaches(false);

            con.setRequestMethod("POST");

            con.setRequestProperty("Connection","Keep-Alive");
            con.setRequestProperty("Charset","UTF-8");
            con.setRequestProperty("Content-Type","multipart/form-data;boundary="+boundary);

            /*设置DataOutputStream*/
            DataOutputStream ds = new DataOutputStream(con.getOutputStream());
            ds.writeBytes(twoHyphens + boundary + end);
            ds.writeBytes("Content-Disposition:form-data;" + "name=\"name\""+end);
            ds.writeBytes(end);




        }catch(Exception e){

        }
    }
}
