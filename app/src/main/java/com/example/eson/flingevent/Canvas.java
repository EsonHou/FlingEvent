package com.example.eson.flingevent;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Eson on 16/4/29.
 */
public class Canvas extends View {
    public Canvas(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setTextSize(50);
        paint.setColor(getResources().getColor(R.color.colorBlue));

        canvas.drawText("长按即可设为壁纸",100,30,paint);



    }
}
