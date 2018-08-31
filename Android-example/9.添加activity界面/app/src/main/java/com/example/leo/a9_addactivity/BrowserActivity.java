package com.example.leo.a9_addactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class BrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        Log.d("test","二级界面创建");

        Intent intent = getIntent();
        String string = intent.getStringExtra("name");
        TextView textView = findViewById(R.id.id_textview);
        textView.setText(string);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test","二级界面销毁");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("test","二级界面显示");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("test","二级面隐藏");
    }

    //    了解生命周期
/*

 */
    public void goback(View view) {

        finish();
    }
}
