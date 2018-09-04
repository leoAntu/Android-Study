package com.example.leo.a14_xiaomi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goPay(View view) {

        BugOpitonDialog log = new BugOpitonDialog();
        log.listener = new BugOpitonDialog.OnCallBackListener() {
            @Override
            public void onDialogInput(String option) {
                Toast.makeText(MainActivity.this, option, Toast.LENGTH_SHORT).show();
            }
        };

        log.show(getFragmentManager(),"log");
    }
}
