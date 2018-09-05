package com.example.leo.a15_jiaohu;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    final int REQ_PICK_IAMGE = 1001;
    final String TAG = "测试MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermissions(); ///检查权限
    }

    // 权限检查： 参照《示例代码》文档的说明
    public boolean checkPermissions()
    {
        // 本app需要以下权限
        final String[] ps = { Manifest.permission.READ_EXTERNAL_STORAGE };

        // 检查是否有这些权限
        int rc = ActivityCompat.checkSelfPermission(this,ps[0]);
        if (rc != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, ps, 0);
            return false;
        }
        return true;
    }

    public void  goTel(View view) {
        Uri uri = Uri.parse("tel:" + "15512345678");
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }

    public void goShare(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "分享文本是打飞机涉及到风口浪尖水电费风口浪尖水电费了");
        startActivity(intent);
    }

    public void selectPic(View view) {
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Intent intent = new Intent(Intent.ACTION_PICK, uri);
        startActivityForResult(intent,REQ_PICK_IAMGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQ_PICK_IAMGE) {
            if (resultCode == RESULT_OK) {

                Uri imageUri = data.getData();
                String[] projection = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver()
                        .query(imageUri, projection, null, null, null);
                cursor.moveToFirst();
                int column = cursor.getColumnIndex(projection[0]);
                String imagePath = cursor.getString(column);
                Log.d(TAG, "选中文件的路径:" + imagePath);

                // 读取图片并显示
                Drawable image = Drawable.createFromPath(imagePath);
                ImageView imageView = findViewById(R.id.id_imageView2);
                imageView.setImageDrawable(image);

            }
        }
    }
}
