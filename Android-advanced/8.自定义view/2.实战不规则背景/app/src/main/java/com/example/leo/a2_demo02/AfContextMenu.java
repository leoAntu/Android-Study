package com.example.leo.a2_demo02;

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
 * Created by shaofa on 2017/12/5.
 */

public class AfContextMenu
{
    final String TAG = "AfContextMenu";

    // PopupWindow
    View contentView;
    PopupWindow popupWindow;

    // ListView
    LayoutInflater layoutInflater;
    MyListAdapter listAdapter;
    ArrayList<MyListItem> listData = new ArrayList();


    public AfContextMenu()
    {
    }

    public PopupWindow getPopupWindow()
    {
        return popupWindow;
    }

    // 添加菜单项
    public void addMenuItem(String option, String value)
    {
        MyListItem it = new MyListItem();
        it.option = option;
        it.value = value;
        listData.add( it );
    }

    // context, 所在Activity
    // anchor, 点中的View
    // xOff, yOff, 偏移量
    public void show(Context context, View anchor, int xOff, int yOff)
    {
        // 创建View
        layoutInflater = LayoutInflater.from(context);
        contentView = layoutInflater.inflate(R.layout.af_context_menu, null);

        // 设置不规则背景
        CustomBg bg = new CustomBg();
        bg.position = CustomBg.TOP_RIGHT; // 箭头位置
        bg.arrowSize = 30;
        contentView.setBackground( bg );
        int p = bg.arrowSize + 10;
        contentView.setPadding(p, p, p, p);

        // 初始化窗口里的内容
        initContentView();

        // 创建PopupWindow, 宽度恒定，高度自适应
        popupWindow = new PopupWindow(contentView, 400,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.showAsDropDown(anchor, xOff, yOff);
    }

    // 初始化
    private void initContentView() {
        // 初始化ListView
        listAdapter = new MyListAdapter();
        ListView listView = (ListView) contentView.findViewById(R.id.id_listview);
        listView.setAdapter(listAdapter); // 设置适配器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                MyListItem it = (MyListItem) listAdapter.getItem(position);
                onItemClicked(view, it);
            }
        });
    }

    // 回调
    public interface OnMenuItemClickedListener
    {
        public void onMenuItemClicked(String option, String value);
    }
    public OnMenuItemClickedListener listener;


    // 点击菜单项
    private void onItemClicked(View view, MyListItem it)
    {
        // 关闭窗口
        popupWindow.dismiss();

        // 回调
        if(listener != null)
        {
            listener.onMenuItemClicked(it.option, it.value);
        }
    }


    ///////////// 每一条记录的数据 /////////
    private static class MyListItem
    {
        public String option;
        public String value;
    }

    //////////// 适配器 //////////////////
    private class MyListAdapter extends BaseAdapter
    {
        @Override
        public int getCount()
        {
            return listData.size();
        }

        @Override
        public Object getItem(int position)
        {
            return listData.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            // 创建控件
            if (convertView == null)
            {
                // 使用外部类里的 layoutInflater;
                convertView = layoutInflater
                        .inflate(R.layout.af_context_menu_item, parent, false);
            }

            // 获取/显示数据
            MyListItem it = (MyListItem) getItem(position);
            ((TextView) convertView.findViewById(R.id.id_menu_item_text)).setText(it.option);

            return convertView;
        }
    }
}
