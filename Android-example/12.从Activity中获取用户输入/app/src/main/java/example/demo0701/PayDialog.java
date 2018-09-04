package example.demo0701;

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
 * Created by dingdongqianbaofuyin on 2018/9/3.
 */

public class PayDialog extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // 创建View, 指定布局XML
        View v = inflater.inflate(R.layout.dialog_pay, container);
        //或者btn
        Button btn = (Button)v.findViewById(R.id.id_okbtn);
        //设置btn点击事件
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

//        Window window = getDialog().getWindow();
//        if (window == null) return;
//
//        window.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
//        WindowManager.LayoutParams lp = window.getAttributes();
//        lp.dimAmount = 0.3f; // 背景灰度
//        lp.gravity = Gravity.BOTTOM; //靠下显示
//        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
//        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//        window.setAttributes(lp);
    }
}
