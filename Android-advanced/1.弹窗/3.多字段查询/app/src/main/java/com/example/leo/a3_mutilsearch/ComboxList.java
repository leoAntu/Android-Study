package com.example.leo.a3_mutilsearch;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dingdongqianbaofuyin on 2018/9/6.
 */

public class ComboxList {

    ArrayList<Option> listData = new ArrayList();
    MyListAdapter listAdapter;

    LayoutInflater layoutInflater;
    View contentView;
    PopupWindow window;
    public interface OnComboxListListener {
        public void OnItemClickedListener(Option option);
    }
    public OnComboxListListener listener;

    public void addOptions(Option[] options) {
        listData.clear();
        for (Option op: options) {
            listData.add(op);
        }
    }

    public void show(Context context, View anchor, int xOff, int yOff) {
        layoutInflater = LayoutInflater.from(context);
        contentView = layoutInflater.inflate(R.layout.combox_list_menu,null);

        initContentView();

        window = new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setFocusable(true);
        window.setBackgroundDrawable(new ColorDrawable());
        window.showAsDropDown(anchor,xOff,yOff);
    }


    // 初始化
    private void initContentView() {
        listAdapter = new MyListAdapter();
        final ListView listView = contentView.findViewById(R.id.id_combox_list);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Option op = listData.get(position);
                window.dismiss();
                if (listener != null) {
                    listener.OnItemClickedListener(op);
                }
            }
        });
    }

    public static class Option {
        public String name;     // 名字
        public String value;    // 值
        public Drawable icon;   // 图标
        public Option(){}
        public Option(String name, String value, Drawable icon)
        {
            this.name = name;
            this.value = value;
            this.icon = icon;
        }
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
                convertView = layoutInflater.inflate(R.layout.combox_list_item,parent,false);
            }
            Option option = (Option)getItem(position);
            ((TextView)convertView.findViewById(R.id.id_combox_item_text)).setText(option.name);
            return convertView;
        }
    }
}
