package com.example.hui.communitition;

import android.app.usage.UsageEvents;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.EventListener;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private TextView headText = null;
    private Button redButton = null;
    private Button greenButton = null;
    private Button blueButton = null;
    private Button eButton = null;
    private Button sButton = null;
    private Button blodButton = null;
    private Button italicButton = null;
    private Button defaultButton = null;
    private EditText editText = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        headText = (TextView)findViewById(R.id.headText);
        redButton = (Button)findViewById(R.id.redButton);
        greenButton = (Button)findViewById(R.id.greenButton);
        blueButton = (Button)findViewById(R.id.blueButton);
        eButton = (Button)findViewById(R.id.eButton);
        sButton = (Button)findViewById(R.id.sButton);
        blodButton = (Button)findViewById(R.id.blodButton);
        italicButton = (Button)findViewById(R.id.italicButton);
        defaultButton = (Button)findViewById(R.id.defaultButton);
        editText = (EditText)findViewById(R.id.editText);

        ColorListenter listenter = new ColorListenter();
        redButton.setOnClickListener(listenter);
        greenButton.setOnClickListener(listenter);
        blueButton.setOnClickListener(listenter);

        SizeListener sizeListener = new SizeListener(headText);
        eButton.setOnClickListener(sizeListener);
        sButton.setOnClickListener(sizeListener);

        blodButton.setOnClickListener(this);
        italicButton.setOnClickListener(this);
        defaultButton.setOnClickListener(this);


        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                headText.setText(editText.getText().toString());
                editText.setText(null);
                return false;
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.blodButton:
                headText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD);
                break;
            case R.id.italicButton:
                headText.setTypeface(Typeface.MONOSPACE,Typeface.ITALIC);
                break;
            case R.id.defaultButton:
                headText.setTypeface(Typeface.DEFAULT);
                break;
            default:
                break;
        }
    }


    class ColorListenter implements OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.redButton:
                    headText.setTextColor(Color.RED);
                    break;
                case R.id.greenButton:
                    headText.setTextColor(Color.GREEN);
                    break;
                case R.id.blueButton:
                    headText.setTextColor(Color.BLUE);
                    break;
                default:
                    break;
            }
        }
    }
}
