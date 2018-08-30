package com.example.leo.android_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        目录结构
//        mainfests  应用清单，描述app所包含的东西
//       java: 程序代码
//       res: 应用所需的资源文件
//               drawble: 颜色相关的设置
//              layout : 布局

//        Gradle ：编译打包工具

//        修改textview
//        findViewById: 返回值是view类，
//        TextView view = (TextView)findViewById(R.id.id_hello);
//        view.setText("helloafa");

//    方式1    获取button2，纯代码添加点击事件
        Button btn = (Button)findViewById(R.id.id_btn_2);
        MyButtonListener listener = new MyButtonListener();
//        btn.setOnClickListener(listener);
//        方式2 匿名类方法，主流都是这样写
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView v2 = (TextView)findViewById(R.id.id_text_1);
                v2.setText("你好阿发");
            }
        });
    }

//    按钮点击事件 xml中实现
    public void  onBtnCliked(View view) {
        System.out.println("qweqweqweqwe");
        TextView v = (TextView)findViewById(R.id.id_text_1);
        v.setText("helloafa");
    }

//    纯代码添加点击事件,必须实现OnClickListener接口
    private class  MyButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            TextView v1 = (TextView)findViewById(R.id.id_text_1);
            v1.setText("你好阿发");
        }
    }
}
