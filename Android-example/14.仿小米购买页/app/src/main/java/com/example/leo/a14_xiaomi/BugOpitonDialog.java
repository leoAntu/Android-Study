package com.example.leo.a14_xiaomi;

import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by dingdongqianbaofuyin on 2018/9/4.
 */

public class BugOpitonDialog extends DialogFragment {

    View contentView;

    //定义回调接口
    public interface OnCallBackListener {
        void onDialogInput(String option);
    }
    //声明回调接口对象
    public OnCallBackListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        //获取xml
        contentView = inflater.inflate(R.layout.dialog_buy_option, container);

        //获取确定按钮
        Button btn = contentView.findViewById(R.id.id_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                readUserInput();
            }
        });
//        //获取关闭按钮
//        Button closeBtn = (Button) contentView.findViewById(R.id.id_close);
//        closeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dismiss();
//            }
//        });
        return contentView;
    }

    private void readUserInput() {
        if (listener != null) {
            listener.onDialogInput("购买成功了！！");
        }
    }


    @Override
    public void onStart() {
        super.onStart();

//        Window window = getDialog().getWindow();
//        if (window == null) return;
//
//        window.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
//
//        WindowManager.LayoutParams lp = window.getAttributes();
//        lp.dimAmount = 0.3f;
//        lp.gravity = Gravity.BOTTOM;
//        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
//        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//
//        window.setAttributes(lp);
    }
}
