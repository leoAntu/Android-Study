package com.example.leo.a2_demo02;

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

    public void showPopupMenu(View view) {
        AfContextMenu menu = new AfContextMenu();
        // 添加菜单项
        menu.addMenuItem("编辑", "edit");
        menu.addMenuItem("删除", "delete");
        menu.addMenuItem("共享", "sendto");

        // 菜单事件处理
        menu.listener = new AfContextMenu.OnMenuItemClickedListener()
        {
            @Override
            public void onMenuItemClicked(String option, String value) {
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        };
        menu.show(this, view, 0,30); // 30: 菜单窗口与anchor的纵向位移
    }
}
