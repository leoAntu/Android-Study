package com.example.leo.a1_drawerlayout;

import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MyDrawerListItem> listData = new ArrayList();
    MyListAdapter listAdapter;
    // 抽屉
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout)findViewById(R.id.id_drawer_layout);
        drawerLayout.setScrimColor(0xAACCCCCC);

        listAdapter = new MyListAdapter();
        ListView listView = (ListView)findViewById(R.id.id_drawer_list);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "点击了：" + position, Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(Gravity.START,true);
            }
        });

        // 初始化抽屉里的菜单项
        listData.add(new MyDrawerListItem("我的超级会员", "cmd1", null));
        listData.add(new MyDrawerListItem("QQ钱包",   "cmd2", null));
        listData.add(new MyDrawerListItem("个性装扮", "cmd3", null));
        listData.add(new MyDrawerListItem("我的收藏", "cmd4", null));
        listData.add(new MyDrawerListItem("我的相册", "cmd5", null));
        listData.add(new MyDrawerListItem("我的文件", "cmd6", null));
        listData.add(new MyDrawerListItem("我的超级会员", "cmd1", null));
        listData.add(new MyDrawerListItem("QQ钱包",   "cmd2", null));
        listData.add(new MyDrawerListItem("个性装扮", "cmd3", null));
        listData.add(new MyDrawerListItem("我的收藏", "cmd4", null));
        listData.add(new MyDrawerListItem("我的相册", "cmd5", null));
        listData.add(new MyDrawerListItem("我的文件", "cmd6", null));
    }

    ///////////// 每一条记录的数据 /////////
    static class MyDrawerListItem
    {
        public String title; // 菜单项显示文本
        public String cmd; // 菜单项对应的命令
        public Drawable icon; // 菜单项左侧显示的图标(本例忽略)

        public MyDrawerListItem(){}
        public MyDrawerListItem(String title, String cmd, Drawable icon)
        {
            this.title = title;
            this.cmd = cmd;
            this.icon = icon;
        }
    }

    private  class  MyListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return listData.size();
        }

        @Override
        public Object getItem(int position) {
            return listData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.drawer_list_item,parent,false);
            }
            MyDrawerListItem item = (MyDrawerListItem)getItem(position);
            ((TextView)convertView.findViewById(R.id.id_drawer_text)).setText(item.title);
            return convertView;
        }
    }
}
