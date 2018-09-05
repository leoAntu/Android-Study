package com.example.leo.a16_login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import static com.example.leo.a16_login.Global.i;

public class UserLoginActivity extends AppCompatActivity {

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        //取出用户信息，下次开机启动时加载
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        String username = preferences.getString("username","");
        String password = preferences.getString("password","");
        if (username.length() > 0 && password.length() > 0) {
            ((EditText)findViewById(R.id.id_login_name)).setText(username);
            ((EditText)findViewById(R.id.id_login_password)).setText(password);
            //延时N毫秒自动登录
            autoLogin();
        }

    }

    private void autoLogin() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                doLogin(null);
            }
        }, 1500);
    }

    public void doLogin(View view) {

        //获取当前输入的信息
        String username = ((EditText)findViewById(R.id.id_login_name)).getText().toString();
        String password = ((EditText)findViewById(R.id.id_login_password)).getText().toString();

        if (username.length() == 0 || password.length() == 0) {
            Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
            return;
        }


        // 从文件里加载所有用户的数据

        File file = new File(getExternalFilesDir(""),"user.txt");
        UserManager um = new UserManager(file);
        try {
            um.load();
        } catch (Exception e) {

        }

        // 从用户列表里查找用户
        User u = um.find(username);
        if(u == null)
        {
            Toast.makeText(this, "无此用户!", Toast.LENGTH_SHORT).show();
            return;
        }

        // 比较密码是否区配
        if(! u.password.equals( password))
        {
            Toast.makeText(this, "密码错误!", Toast.LENGTH_SHORT).show();
            return;
        }
        // 登录成功, 把用户信息放在全局对象里, 以便在各个Activity里都可以访问当前用户信息
        i.username = username;

        //保存用户信息，下次开机启动时加载
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.commit();

        // 进入主界面
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();  // 注意: 关闭本界面, 从MainActivity点返回时应达到桌面, 不应回到登录界面

    }

    public void doRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
