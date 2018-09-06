package com.example.leo.a1_popwindow;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showPopup(View anchor) {
        //获取view
        View contentView = getLayoutInflater().inflate(R.layout.popup_test, null);

        // 创建PopupWindow
        PopupWindow popupWindow = new PopupWindow(contentView, 600, 300);
        popupWindow.setFocusable(true); //是否具有焦点
        //必须要加一个drawble，否则不能消失
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.showAsDropDown(anchor, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener()
        {
            @Override
            public void onDismiss()
            {
                Log.d("tests11", "PopupWindow已经关闭!");
            }
        });
    }
}
