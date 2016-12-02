package com.example.eson.flingevent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Eson on 16/7/5.
 */
public class BroadcastReceiver_ extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"广播已接受",Toast.LENGTH_SHORT).show();
        Toast.makeText(context,"",Toast.LENGTH_SHORT).show();



    }
}
