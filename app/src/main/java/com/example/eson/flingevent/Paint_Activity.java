package com.example.eson.flingevent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class Paint_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint_);
        init();
    }

    public void init(){
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.paint);
        CanvasTest canvasTest = new CanvasTest(this);
        canvasTest.setMinimumHeight(500);
        canvasTest.setMinimumWidth(300);
        canvasTest.invalidate();//通知组件重绘
        linearLayout.addView(canvasTest);
    }
}
