package com.example.leo.a2_demo02;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by shaofa on 2018/3/5.
 */

public class CustomBg extends Drawable
{
    public int position = RIGHT_TOP; // 箭头方向
    public int arrowSize = 20; // 箭头大小
    public int radius = 40;

    public static final int TOP_LEFT = 1;
    public static final int TOP_MIDDLE = 2;
    public static final int TOP_RIGHT = 3;
    public static final int RIGHT_TOP = 4;
    public static final int RIGHT_MIDDLE = 5;
    public static final int RIGHT_BOTTOM = 6;
    public static final int BOTTOM_LEFT = 7;
    public static final int BOTTOM_MIDDLE = 8;
    public static final int BOTTOM_RIGHT = 9;
    public static final int LEFT_TOP = 10;
    public static final int LEFT_MIDDLE = 11;
    public static final int LEFT_BOTTOM = 12;

    public CustomBg()
    {
    }

    public CustomBg(int position)
    {
        this.position = position;
    }

    @Override
    public void draw(@NonNull Canvas canvas)
    {
        //Rect rect = new Rect(0, 0, this.getWidth(), this.getHeight());
        Rect rect = this.getBounds();
        int a = this.arrowSize; // 边距
        int r = this.radius; // 圆角in px
        float x1 = rect.left+a+1, y1 = rect.top+a+1, x2=rect.right-a-1, y2=rect.bottom-a-1;
        float xx = rect.right;
        float yy = rect.top;

        // 添加一个圆形的clip区域
        Path path = new Path();
        path.arcTo(x1 , y1, x1 + r, y1 + r, 180, 90, true); // 左上
        // 上方
        if(position == TOP_LEFT)
        {
            float m = x1 + r + a;
            path.lineTo(m - a,        y1 );
            path.lineTo(m,            y1 - a);
            path.lineTo(m + a,        y1);
        }
        if(position == TOP_MIDDLE)
        {
            float m = (x1 + x2) / 2;
            path.lineTo(m - r* a,        y1 );
            path.lineTo(m,                  y1 - a);
            path.lineTo(m + r* a,        y1);
        }
        if(position == TOP_RIGHT)
        {
            float m = x2 - r - a;
            path.lineTo(m - a,        y1 );
            path.lineTo(m,            y1 - a);
            path.lineTo(m + a,        y1);
        }

        path.arcTo(x2-r , y1, x2, y1 + r, 270, 90, false);  // 右上
        if(position == RIGHT_TOP)
        {
            float m = y1 + r + a;
            path.lineTo(x2,                             m - a);
            path.lineTo(x2 + a,                         m);
            path.lineTo(x2,                             m + a);
        }
        if(position == RIGHT_MIDDLE)
        {
            float m = (y1+y2)/2;
            path.lineTo(x2,                             m - a);
            path.lineTo(x2 + a,                         m);
            path.lineTo(x2,                             m + a);
        }
        if(position == RIGHT_BOTTOM)
        {
            float m = y2 - r -a ;
            path.lineTo(x2,                             m - a);
            path.lineTo(x2 + a,                    m);
            path.lineTo(x2,                             m + a);
        }

        path.arcTo(x2-r,  y2-r, x2, y2, 0, 90, false); // 右下
        // 下方
        if(position == BOTTOM_LEFT)
        {
            float m = x1 + r + a;
            path.lineTo(m + a,        y2);
            path.lineTo(m,            y2 + a);
            path.lineTo(m - a,        y2 );
        }
        if(position == BOTTOM_MIDDLE)
        {
            float m = (x1+x2)/2;
            path.lineTo(m + a,        y2);
            path.lineTo(m,            y2 + a);
            path.lineTo(m - a,        y2 );
        }
        if(position == BOTTOM_RIGHT)
        {
            float m = x1 + r  + a;
            path.lineTo(m + a,        y2);
            path.lineTo(m,            y2 + a);
            path.lineTo(m - a,        y2 );
        }

        path.arcTo(x1,  y2-r, x1+r, y2, 90, 90, false); // 左下
        if(position == LEFT_TOP)
        {
            float m = y1 + r + a;
            path.lineTo(x1,                             m + a);
            path.lineTo(x1 - a,                         m);
            path.lineTo(x1,                             m - a);
        }
        if(position == LEFT_MIDDLE)
        {
            float m = (y1+y2)/2;
            path.lineTo(x1,                             m + a);
            path.lineTo(x1 - a,                         m);
            path.lineTo(x1,                             m - a);
        }
        if(position == LEFT_BOTTOM)
        {
            float m = y2 - r -a ;
            path.lineTo(x1,                             m + a);
            path.lineTo(x1 - a,                    m);
            path.lineTo(x1,                             m - a);
        }
        path.close();

        // 背景透明
        Paint bg = new Paint();
        bg.setColor(0x00ffffff);
        canvas.drawRect(rect, bg);

        Paint paint = new Paint();
        paint.setColor(0xFF666666); // 边框
        paint.setStrokeWidth(2f);
        paint.setStyle(Paint.Style.STROKE); // STROKE: 只画边框  FILL: 只填充
        canvas.drawPath(path, paint); // 沿着Path画一个不规则边框

        paint.setColor(0xFFFFFFFF);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint); // 填充 Path 围成的区域
    }

    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int alpha)
    {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter)
    {

    }

    @Override
    public int getOpacity()
    {
        return PixelFormat.OPAQUE;
    }
}
