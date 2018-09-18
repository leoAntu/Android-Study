package com.example.leo.demo3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Bitmap[] images = new Bitmap[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images[0] = BitmapFactory.decodeResource(getResources(),R.drawable.im_ad1);
        images[1] = BitmapFactory.decodeResource(getResources(),R.drawable.im_ad2);
        images[2] = BitmapFactory.decodeResource(getResources(),R.drawable.im_ad3);

        AfCarousel carousel = (AfCarousel) findViewById(R.id.id_carousel);
        carousel.setImages(images);
    }
}
