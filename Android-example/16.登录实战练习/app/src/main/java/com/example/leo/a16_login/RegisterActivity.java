package com.example.leo.a16_login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void doRegist(View view) {
        String username = ((EditText)findViewById(R.id.id_editText)).getText().toString();
        String password = ((EditText)findViewById(R.id.id_editText2)).getText().toString();
        String verify = ((EditText)findViewById(R.id.id_edit3)).getText().toString();

        if (username.length() == 0 || password.length() == 0 || verify.length() == 0) {
            Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(verify)) {
            Toast.makeText(this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
            return;
        }

        //保存用户信息
        User u = new User(username,password);

        File file = new File(getExternalFilesDir(""),"user.txt");
        UserManager um = new UserManager(file);
        try {
            um.load();
        } catch (Exception e) {}

        //检查用户是否存在
        if (um.find(username) != null) {
            Toast.makeText(this, "用户已经存在", Toast.LENGTH_SHORT).show();
            return;
        }

        //添加用户。保存到文件
        um.add(u);
        try {
            um.save();
        } catch (Exception e) {

        } finally {
            Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
        }

    }
}
