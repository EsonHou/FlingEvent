package com.example.eson.flingevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Switch_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_);

        TextView textView = (TextView) findViewById(R.id.switchstatus);
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.textswitch);

        toggleButton.setChecked(true);
        toggleButton.setText("rrrrrr");

    }
}
