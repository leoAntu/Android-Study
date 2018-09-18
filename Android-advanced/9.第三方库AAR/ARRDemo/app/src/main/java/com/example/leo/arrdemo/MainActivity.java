package com.example.leo.arrdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import example.simplelib.SimpleActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onTest(View view) {

        Intent intent = new Intent(this, SimpleActivity.class);
        startActivity(intent);
    }
}
