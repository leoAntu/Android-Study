package com.example.leo.roundicon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dingdongqianbaofuyin on 2018/9/14.
 */

public class RoundIcon extends View {

    Bitmap icon;

    public RoundIcon(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setIcon(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bd = (BitmapDrawable)drawable;
            setIcon(bd.getBitmap());
        }
    }

    public void setIcon(Bitmap bitmap) {
        this.icon = bitmap;
        invalidate();//申请重绘
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int w = getWidth();
        int h = getHeight();

        //取圆形
        float dd = w < h ? w : h;
        float cx = w / 2;
        float cy = h / 2;
        float radius = dd / 2;

        //边框
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0xFFcccccc);
        canvas.drawCircle(cx,cy,radius,paint);

        //绘制图片
        if (icon != null) {

            //设置clips区域
            Path path = new Path();
            path.addCircle(cx,cy,radius,Path.Direction.CCW);
            canvas.clipPath(path);

            //画icon
            Rect srcRect = new Rect(0,0,icon.getWidth(),icon.getHeight());
            Rect dstRect = new Rect(0,0,w,h);
            canvas.drawBitmap(icon,srcRect,dstRect,new Paint());
        }

    }

}
