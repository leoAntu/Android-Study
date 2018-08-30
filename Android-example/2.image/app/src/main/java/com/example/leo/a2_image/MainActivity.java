package com.example.leo.a2_image;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Drawable[] images = new Drawable[2];
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        getDrawable  activity中方法获取本地图片
//        Drawable image = getDrawable(R.drawable.image2);
//        ImageView view = (ImageView)findViewById(R.id.imageView4);
//        view.setImageDrawable(image);

        images[0] = getDrawable(R.drawable.image1);
        images[1] = getDrawable(R.drawable.image2);

    }

    public void  onClicked(View view) {
        index++;
        if (index > 1) {
            index = 0;
        }
        ImageView v = (ImageView)findViewById(R.id.imageView4);
        v.setImageDrawable(images[index]);
    }
}
