package com.example.leo.a10_activity_router;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MyListItem> listData = new ArrayList();
    MyListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        demoData();

        listAdapter = new MyListAdapter();
        GridView gridView = findViewById(R.id.id_gridView);
        gridView.setAdapter(listAdapter);
        gridView.setNumColumns(4);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.this.onItemClick(position);
            }
        });

    }

    private void onItemClick(int position) {
        MyListItem item = (MyListItem)listAdapter.getItem(position);

        Intent intent = new Intent(this,BrowserActivity.class);
        intent.putExtra("website", item.website);
        startActivity(intent);
    }

    // 展示用的数据
    private void demoData()
    {
        MyListItem it = new MyListItem();
        it.title = "阿发你好";
        it.website = "http://afanihao.cn";
        it.icon = getDrawable(R.drawable.ic_afanihao);
        listData.add( it );

        it = new MyListItem();
        it.title = "w3school";
        it.website = "http://www.w3school.com.cn";
        it.icon = getDrawable(R.drawable.ic_w3school);
        listData.add( it );

        it = new MyListItem();
        it.title = "w3school";
        it.website = "http://www.w3school.com.cn";
        it.icon = getDrawable(R.drawable.ic_w3school);
        listData.add( it );

        it = new MyListItem();
        it.title = "w3school";
        it.website = "http://www.w3school.com.cn";
        it.icon = getDrawable(R.drawable.ic_w3school);
        listData.add( it );

        it = new MyListItem();
        it.title = "w3school";
        it.website = "http://www.w3school.com.cn";
        it.icon = getDrawable(R.drawable.ic_w3school);
        listData.add( it );

        it = new MyListItem();
        it.title = "w3school";
        it.website = "http://www.w3school.com.cn";
        it.icon = getDrawable(R.drawable.ic_w3school);
        listData.add( it );
    }

    ///////////// 每一条记录的数据 /////////
    private class MyListItem
    {
        public String title;  // 网站名称
        public Drawable icon; // 显示图标
        public String website; // 网址
    }

    //////////// 适配器 //////////////////
    private class MyListAdapter extends BaseAdapter {

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
                convertView = getLayoutInflater().inflate(R.layout.grid_item, parent, false);
            }

            MyListItem data = (MyListItem)getItem(position);
            TextView textView = convertView.findViewById(R.id.id_textview);
            textView.setText(data.title);
            ImageView imageView = convertView.findViewById(R.id.id_image);
            imageView.setImageDrawable(data.icon);
            return convertView;
        }
    }

}
