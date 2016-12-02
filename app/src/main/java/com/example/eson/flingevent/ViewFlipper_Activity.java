package com.example.eson.flingevent;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class ViewFlipper_Activity extends Activity implements android.view.GestureDetector.OnGestureListener{
    private int [] img = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4};
    private GestureDetector gestureDetector = null;
    private ViewFlipper viewFlipper = null;
    private Activity mactivity = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper_);
        mactivity = this;

        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        gestureDetector = new GestureDetector(this);//声明检测手势事件

        for(int i=0;i<img.length;i++){//添加图片来源
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(img[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);//设置图片呈现方式，此处设置为塞满整个View
            viewFlipper.addView(imageView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        }
        viewFlipper.setAutoStart(true);//设置自动播放事件
        viewFlipper.setFlipInterval(3000);

        if(viewFlipper.isAutoStart() && !viewFlipper.isFlipping()){
            viewFlipper.startFlipping();
        }
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if(e1.getX()-e2.getX()>120){
            Animation lin = AnimationUtils.loadAnimation(mactivity,R.anim.push_left_in);
            Animation lout = AnimationUtils.loadAnimation(mactivity,R.anim.push_left_out);

            viewFlipper.setInAnimation(lin);
            viewFlipper.setOutAnimation(lout);
            viewFlipper.showNext();
            return true;
        }else if(e2.getX()-e1.getX()>120){
            Animation rin = AnimationUtils.loadAnimation(mactivity,R.anim.push_right_in);
            Animation rout = AnimationUtils.loadAnimation(mactivity,R.anim.push_right_out);

            viewFlipper.setInAnimation(rin);
            viewFlipper.setOutAnimation(rout);
            viewFlipper.showPrevious();
            return  true;
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {// 设置点击停止播放
        viewFlipper.stopFlipping();
        viewFlipper.setAutoStart(false);
        return gestureDetector.onTouchEvent(event);//注册手势事件
    }



    @Override
    public void onLongPress(MotionEvent e) {
        longpress();

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

    public void longpress(){
        AlertDialog.Builder ab = new AlertDialog.Builder(ViewFlipper_Activity.this);
        ab.setTitle("Download:");
        ab.setMessage("Do you want save this picture?");
        ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        ab.show();
    }


}
