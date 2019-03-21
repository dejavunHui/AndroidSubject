package com.example.hui.communitition;

import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SizeListener implements OnClickListener {
    private TextView headText = null;


    public SizeListener(TextView headText) {
        this.headText = headText;

    }

    @Override
    public void onClick(View v) {
        float size = headText.getTextSize();
        switch (v.getId()){
            case R.id.eButton:
                size += 2;
                break;
            case R.id.sButton:
                size -= 2;
                break;
            default:
                break;
        }
        if(size >= 72)
            size = 72;
        if(size <= 8)
            size = 8;
        headText.setTextSize(TypedValue.COMPLEX_UNIT_PX,size);
    }
}
