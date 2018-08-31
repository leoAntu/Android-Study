package com.example.leo.a8_stepdebug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        崩溃代码测试
//        Integer a = Integer.valueOf("23.a888");

    }
    public void  onClicked(View view) {
        EditText text = (EditText)findViewById(R.id.id_edit);
        String str = text.getText().toString();
//        打印log
        Log.d(TAG,str);

        Toast.makeText(this, "点击了按钮ewweer:" + str + "sdfsdfsdf", Toast.LENGTH_SHORT).show();
    }
}
