package com.example.leo.roundicon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RoundIcon icon = (RoundIcon)findViewById(R.id.id_icon);
        icon.setIcon(getDrawable(R.drawable.im_sample));
    }
}
