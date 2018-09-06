package com.example.leo.a2_popmenu;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
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
 * Created by dingdongqianbaofuyin on 2018/9/5.
 */

public class AfContextMenu {
    final String TAG = "AfContextMenu";
    ArrayList<MyListItem> listData = new ArrayList();
    MyListAdapter adapter;

    LayoutInflater layoutInflater;
    // PopupWindow
    View contentView;
    PopupWindow popupWindow;

    //回调接口
    public interface OnMenuItemClickedListener {
        public void onMenuItemClicked(String option, String value);
    }

    public OnMenuItemClickedListener listener;

    public AfContextMenu() {

    }

    public void show(Context context, View anchor, int xOff, int yOff) {
        layoutInflater = LayoutInflater.from(context);
        contentView = layoutInflater.inflate(R.layout.af_content_menu, null, false);

        initContentView();

        // 创建PopupWindow, 宽度恒定，高度自适应
        popupWindow = new PopupWindow(contentView, 400,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.showAsDropDown(anchor, xOff, yOff);

    }

    // 初始化
    private void initContentView()
    {
        // 初始化ListView
        adapter = new MyListAdapter();
        ListView listView = (ListView) contentView.findViewById(R.id.id_menu_listView);
        listView.setAdapter(adapter); // 设置适配器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyListItem item = listData.get(position);
                onItemClicked(item);
            }
        });
    }

    private void onItemClicked(MyListItem item) {
        popupWindow.dismiss();
        if (listener == null) return;
        listener.onMenuItemClicked(item.option,item.value);
    }

    //添加单选项
    public void addMenuItem(String option, String value) {
        MyListItem it = new MyListItem();
        it.option = option;
        it.value = value;
        listData.add(it);
    }

//    数据类
    private class MyListItem {
        public String option;
        public String value;
    }

//    适配器类
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
                convertView = layoutInflater.inflate(R.layout.af_content_menu_item, parent, false);
            }

            MyListItem it = (MyListItem) getItem(position);
            ((TextView)convertView.findViewById(R.id.id_content_menu_item)).setText(it.option);
            return convertView;
        }
    }
}
