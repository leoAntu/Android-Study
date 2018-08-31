package com.example.leo.a10_activity_router;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class BrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        //初始化webview
        WebView webView = findViewById(R.id.id_webview);
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);

//        获取传过来的参数
        Intent intent = getIntent();
        String website = intent.getStringExtra("website");

        if (website != null) {
            webView.loadUrl(website);
        }

    }
}
