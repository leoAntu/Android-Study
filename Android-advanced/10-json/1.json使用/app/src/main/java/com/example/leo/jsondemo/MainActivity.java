package com.example.leo.jsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.myjson.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.系统自带JsonObject

        //2.直接去json.org官网下载源码，打成jar包
        JSONObject j1 = new JSONObject();
        j1.put("name","lisi");

    }
}
