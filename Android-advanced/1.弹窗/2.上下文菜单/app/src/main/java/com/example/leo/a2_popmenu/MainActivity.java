package com.example.leo.a2_popmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MyListItem> listData = new ArrayList();
    MyListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listAdapter = new MyListAdapter();
        ListView listView = findViewById(R.id.id_listview);
        listView.setAdapter(listAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                MyListItem item = listData.get(position);
                onItemLongClicked(view, item);
                return false;
            }
        });
        //演示demo
        demo();
    }

    public void  onItemLongClicked(View view, MyListItem item) {
        AfContextMenu menu = new AfContextMenu();
        menu.addMenuItem("发送给朋友", "sendto");
        menu.addMenuItem("收藏", "favorite");
        menu.addMenuItem("删除", "remove");
        menu.addMenuItem("更多", "more");

        menu.show(this,view,view.getWidth()/2,-view.getHeight()/2);

        menu.listener = new AfContextMenu.OnMenuItemClickedListener() {
            @Override
            public void onMenuItemClicked(String option, String value) {
                String str = "点中了：" + option + "," + value;
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        };

    }

    private void demo() {
        MyListItem it;
        it = new MyListItem();
        it.text = "坚持练习，保持热爱，时间会报答你的努力。";
        listData.add(it);

        it = new MyListItem();
        it.text = "编程是一门职业技术，不要以混过考试的目的来学习编程。";
        listData.add(it);

        it = new MyListItem();
        it.text = "最佳实践：每天2集左右，多了没用。必须坚持每天都学都练，三天打渔两天晒网是学不会的。";
        listData.add(it);

        it = new MyListItem();
        it.text = "曾经有一份课程摆在你面前，你却没有珍惜，直到几年之后你才追悔莫及。";
        listData.add(it);

        listAdapter.notifyDataSetChanged();;
    }

    private class MyListItem {
        public String text;
    }

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
                convertView = getLayoutInflater().inflate(R.layout.list_item_msg,parent,false);
            }
            MyListItem item = (MyListItem) getItem(position);
            ((TextView)convertView.findViewById(R.id.id_textView)).setText(item.text);
            return convertView;
        }
    }
}
