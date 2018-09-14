package com.example.leo.a123;

import android.content.pm.ActivityInfo;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    final String TAG = "测试MainActivity";
    private int orientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        Log.w(TAG, "onCreate...");

        orientation = getResources().getConfiguration().orientation;
        if (orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main_portrait);
            Log.d(TAG,"现在为竖屏模式portrait...");
        } else {
            setContentView(R.layout.activity_main_landscape);
            Log.d(TAG,"现在为横屏模式landscape...");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w(TAG, "onDestroy...");

    }
}
