package com.example.leo.a11_custom_navigationbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.id_title);
        textView.setText("你好！");
    }

    public void onBack(View view) {
        onBackPressed(); //返回按钮
    }
}
