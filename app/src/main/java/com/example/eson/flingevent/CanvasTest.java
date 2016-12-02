package com.example.eson.flingevent;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;

/**
 * Created by Eson on 16/4/26.
 */
public class CanvasTest extends View {
    public CanvasTest(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();//创建画笔
        paint.setColor(getResources().getColor(R.color.colorRed));

        paint.setTextSize(20);
        canvas.drawText("画图：", 10, 40, paint);//绘制文本

        canvas.drawCircle(100, 40, 20, paint);//绘制小圆
        paint.setAntiAlias(true);//声明圆的锯齿效果，true是去除
        canvas.drawCircle(180, 40, 35, paint);//绘制大圆

        paint.setTextSize(20);
        paint.setColor(getResources().getColor(R.color.colorBlue));
        canvas.drawText("直线及斜线：", 10, 120, paint);

        canvas.drawLine(120, 120, 300, 120, paint);//绘制直线
        canvas.drawLine(300, 120, 400, 250, paint);//绘制斜线

        paint.setColor(getResources().getColor(R.color.colorAccent));
        canvas.drawText("弧线：", 10, 350, paint);
        paint.setStyle(Paint.Style.STROKE);//设置为空心弧线
        RectF ovall = new RectF(120,300,220,400);//声明绘制图形区域

        canvas.drawArc(ovall, 180, 180, false, paint);//第二个参数是起始角度，第三个是圆心角的角度,第四个是是否为中心(是否封闭)
        ovall.set(270, 300, 370, 400);//重新设定绘制区域
        canvas.drawArc(ovall, 180, 180, false, paint);

        ovall.set(165, 350, 325, 500);
        canvas.drawArc(ovall, 0, 180, false, paint);

        paint.setColor(getResources().getColor(R.color.colorPrimaryDark));
        canvas.drawText("正方形、长方形", 10, 520, paint);
        canvas.drawRect(120, 520, 200, 600, paint);//绘制正方形，参数一次是：左边X坐标，上边Y坐标，右边X坐标，下边Y坐标
        canvas.drawRect(120, 620, 320, 720, paint);//绘制长方形，参数一次是：左边X坐标，上边Y坐标，右边X坐标，下边Y坐标

        canvas.drawText("扇形和椭圆", 10, 750, paint);
        Shader shader = new LinearGradient(0,0,100,100,new int[] {getResources().getColor(R.color.colorBlue)//设置填充区域的渐变色
                ,getResources().getColor(R.color.colorYellow),getResources().getColor(R.color.colorPrimaryDark),
                getResources().getColor(R.color.colorPuple),getResources().getColor(R.color.colorGreen),
                getResources().getColor(R.color.colorRedB)},null, Shader.TileMode.MIRROR);
        paint.setShader(shader);
        paint.setStyle(Paint.Style.FILL);
        RectF ovall2 = new RectF(120,750,400,1030);
        canvas.drawArc(ovall2,210,120,true,paint);

        RectF ovall3 = new RectF(500,750,800,1050);
        Shader shader1 = new LinearGradient(0,0,100,100,new int[] {getResources().getColor(R.color.colorBlue)//设置填充区域的渐变色
                ,getResources().getColor(R.color.colorYellow),getResources().getColor(R.color.colorPrimaryDark),
                getResources().getColor(R.color.colorPuple),getResources().getColor(R.color.colorGreen),
                getResources().getColor(R.color.colorRedB)},null, Shader.TileMode.REPEAT);
        paint.setShader(shader1);
        canvas.drawArc(ovall3, 210, 120, true, paint);

        paint.setShader(shader);
        RectF ovall4 = new RectF(120,1100,520,1300);
        canvas.drawRoundRect(ovall4,20,15,paint);//绘制圆角矩形，第二个参数是X半径，第三个参数是Y半径
       // canvas.drawOval(ovall4,paint);//绘制椭圆或者圆形，取决于ovall4的区域形状

        //绘制封闭多边形角形
        Path path = new Path();
        path.moveTo(620,1000);
        path.lineTo(620, 1400);
        path.lineTo(820, 1400);
        path.close();
        canvas.drawPath(path,paint);

        //绘制点
        canvas.drawPoint(120,1500,paint);
        canvas.drawPoints(new float[]{200, 1500, 240, 1500, 280, 1500, 320, 1500}, paint);

        //绘制图片
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.img4);
        //canvas.drawBitmap(bitmap,200,200,paint);
        Rect rect = new Rect(200,200,200,200);//第二个参数
        RectF ovall5= new RectF(120,300,520,500);
        canvas.drawBitmap(bitmap,null,ovall5,paint);//第二个参数是对图片进行裁截，若是空null则显示整个图片






    }
}
