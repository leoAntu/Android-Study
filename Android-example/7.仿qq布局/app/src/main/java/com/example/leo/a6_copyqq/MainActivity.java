package com.example.leo.a6_copyqq;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<QQGoup> listData = new ArrayList();
    MyListViewAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QQGoup g1 = new QQGoup();
        g1.title = "阿发你好#1 (C++)";
        g1.lastMessage = "群主: 加油少年";
        g1.lastMessageTime = "18:30";
        g1.icon = getDrawable(R.drawable.im_qqgroup1);

        QQGoup g2 = new QQGoup();
        g2.title = "阿发你好#7 (Java)";
        g2.lastMessage = "群主: 加油少年";
        g2.lastMessageTime = "14:09";
        g2.icon = getDrawable(R.drawable.im_qqgroup2);

        listData.add(g1);
        listData.add(g2);

        listAdapter = new MyListViewAdapter();
        ListView listView = (ListView)findViewById(R.id.id_list);
        listView.setAdapter(listAdapter);
    }

    private class QQGoup {
        public String title;  // 群名称
        public Drawable icon;
        public String lastMessage;
        public String lastMessageTime;
    }

    public class MyListViewAdapter extends BaseAdapter {

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
                convertView = getLayoutInflater().inflate(R.layout.list_item_qq,parent,false);
            }

            QQGoup data = (QQGoup) getItem(position);
            TextView textView = (TextView)convertView.findViewById(R.id.id_title);
            textView.setText(data.title);
            textView = (TextView) convertView.findViewById(R.id.id_message);
            textView.setText(data.lastMessage);
            textView = (TextView) convertView.findViewById(R.id.id_title);
            textView.setText(data.lastMessageTime);

            ImageView imageView = (ImageView)convertView.findViewById(R.id.id_icon);
            imageView.setImageDrawable(data.icon);
            return convertView;
        }
    }
}
