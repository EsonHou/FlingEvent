package com.example.eson.flingevent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class Right_Activity extends AppCompatActivity {
    public float x1;
    public float x2;
    public float y1;
    public float y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_);
        TextView text = (TextView) findViewById(R.id.text);

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

        if(x2-x1>50){
            Intent intent = new Intent(Right_Activity.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onTouchEvent(event);
    }
}
