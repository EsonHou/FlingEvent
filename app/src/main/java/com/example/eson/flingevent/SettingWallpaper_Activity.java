package com.example.eson.flingevent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.io.IOException;

public class SettingWallpaper_Activity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    private int []img = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.imd5,R.drawable.img6,R.drawable.img7};
    private ViewFlipper viewFlipper = null;
    private GestureDetector gestureDetector = null;
    private Activity activity = null;
    private int ac;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_wallpaper_);
        activity = this;

        viewFlipper = (ViewFlipper) findViewById(R.id.img);
        gestureDetector = new GestureDetector(this);

        for(int i=0;i<img.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(img[i]);
            this.ac = img[i];
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

            setWallpaper();
        }
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(3000);
        if(!viewFlipper.isFlipping() && viewFlipper.isAutoStart()){
            viewFlipper.startFlipping();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
            viewFlipper.stopFlipping();
            viewFlipper.setAutoStart(false);

        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

        return false;

    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if(e2.getX()-e1.getX() >120){
            Animation rin = AnimationUtils.loadAnimation(activity, R.anim.push_right_in);
            Animation rout = AnimationUtils.loadAnimation(activity,R.anim.push_right_out);

            viewFlipper.setInAnimation(rin);
            viewFlipper.setOutAnimation(rout);
            viewFlipper.showPrevious();

            return  true;
        }else if(e1.getX()-e2.getX()>120){
            Animation lin = AnimationUtils.loadAnimation(activity,R.anim.push_left_in);
            Animation lout = AnimationUtils.loadAnimation(activity,R.anim.push_left_out);

            viewFlipper.setInAnimation(lin);
            viewFlipper.setOutAnimation(lout);
            viewFlipper.showNext();
            return  true;
        }
        return true;
    }

    public void setWallpaper(){

        viewFlipper.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                try {
                    SettingWallpaper_Activity.this.clearWallpaper();
                    SettingWallpaper_Activity.this.setWallpaper(SettingWallpaper_Activity.this.getResources().openRawResource(ac));

                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    startActivity(intent);

                    Toast.makeText(SettingWallpaper_Activity.this,"设置壁纸成功",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(SettingWallpaper_Activity.this,"设置壁纸失败",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                return true;
            }
        });
    }
}
/**
 viewFlipper.setOnLongClickListener(new View.OnLongClickListener() {
@Override
public boolean onLongClick(View v) {
try {
SettingWallpaper_Activity.this.clearWallpaper();
System.out.println(ac + "********************");
SettingWallpaper_Activity.this.setWallpaper(ac);
Intent intent = new Intent(Intent.ACTION_MAIN);
intent.addCategory(Intent.CATEGORY_HOME);
startActivity(intent);

Toast.makeText(SettingWallpaper_Activity.this, "设置壁纸成功", Toast.LENGTH_SHORT).show();
} catch (IOException e) {
Toast.makeText(SettingWallpaper_Activity.this, "设置壁纸失败", Toast.LENGTH_SHORT).show();
e.printStackTrace();
}
return true;
}
});
 **/