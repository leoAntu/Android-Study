package com.example.leo.a9_addactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("test","主界面创建");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test","主界面 销毁");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("test","主界面显示");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("test","主界面隐藏");
    }

    public void baiduClicked(View view) {
        Intent intent = new Intent(this, BrowserActivity.class);
        intent.putExtra("name", "www.baidu.com");
        startActivity(intent);
    }

    public void sinaClicked(View view) {
        Intent intent = new Intent(this, BrowserActivity.class);
        intent.putExtra("name", "www.sina.com");
        startActivity(intent);
    }
}
