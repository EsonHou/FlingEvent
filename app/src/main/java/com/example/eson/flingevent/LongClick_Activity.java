package com.example.eson.flingevent;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class LongClick_Activity extends AppCompatActivity {
    private ImageView img = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_long_click_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        img = (ImageView) findViewById(R.id.img);
        img.setImageResource(R.drawable.img4);
        img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                try {
                    LongClick_Activity.this.clearWallpaper();//设置桌面壁纸
                    LongClick_Activity.this.setWallpaper(LongClick_Activity.this.getResources().openRawResource(R.drawable.img3));

                    Intent home = new Intent(Intent.ACTION_MAIN);//返回到主界面
                    home.addCategory(Intent.CATEGORY_HOME);
                    startActivity(home);

                    Toast.makeText(LongClick_Activity.this,"更换壁纸成功",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(LongClick_Activity.this,"更换壁纸失败",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }
}
