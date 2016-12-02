package com.example.eson.flingevent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public float x1;
    public float x2;
    public float y1;
    public float y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            x1 = event.getX();
            y1 = event.getY();
        }

        if(event.getAction() == MotionEvent.ACTION_UP){
            x2 = event.getX();
            y2 = event.getY();
        }

        if(y2-y1>50){
            //Toast 是一个 View 视图，快速的为用户显示少量的信息
            Toast.makeText(MainActivity.this,"向下滑",Toast.LENGTH_SHORT).show();
        }else if(x1-x2>50){
            Intent intent = new Intent(MainActivity.this,Right_Activity.class);
            startActivity(intent);
        }else{

        }
        return super.onTouchEvent(event);
    }
}
