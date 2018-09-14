package com.example.leo.a6_smalltask;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * Created by dingdongqianbaofuyin on 2018/9/14.
 */

public class CustomDialog {

    View contentView;
    PopupWindow popupWindow = new PopupWindow();
    LayoutInflater inflater;

    public void show(Context context, View anchor) {
        inflater = LayoutInflater.from(context);
        contentView = inflater.inflate(R.layout.custom_dialog,null);

        //创建pop
        popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(false);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.showAtLocation(anchor, Gravity.CENTER,0,0);
    }

    public void dismiss() {
        popupWindow.dismiss();
    }
}
