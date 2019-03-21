package com.example.root.sr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.tensorflow.TensorFlow;
import org.tensorflow.contrib.android.TensorFlowInferenceInterface;
import org.opencv.core.Core;

public class MainActivity extends AppCompatActivity {


    static{
        System.loadLibrary("tensorflow_inference");
    }

    private static final String model_file = "file:///android_assets/ESPCN-YCbCr-480-x3.pb";
    private static final String input_node = "input:0";
    private static final String output_node = "output:0";

    private TensorFlowInferenceInterface inferenceInterface;
    private float[] floatValues;
    private float[] floatValuess;

    private ImageView imageView;
    private static final String  TAG = "OCVSAMPLE::Activity";

    private BaseLoaderCallback baseLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status){
                case LoaderCallbackInterface.SUCCESS: {
                    Log.i(TAG, "opencv加载成功");
                } break;

                default:{
                    super.onManagerConnected(status);
                }break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
