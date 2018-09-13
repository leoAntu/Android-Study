package com.example.leo.a2wechatpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MsgFragment extends Fragment {

    View contentView;
    MyListAdapter listAdapter;
    ArrayList<MyListItem> listData = new ArrayList();


    public MsgFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        contentView = inflater.inflate(R.layout.fragment_msg, container, false);

        listAdapter = new MyListAdapter();
        ListView listView = contentView.findViewById(R.id.id_msg_list);
        listView.setAdapter(listAdapter);
        return contentView;
    }

    @Override
    public void onStart() {
        super.onStart();

        demo();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    // 演示数据
    private void demo()
    {
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

        listAdapter.notifyDataSetChanged();
    }

    ///////////// 每一条记录的数据 /////////
    private static class MyListItem
    {
        public String text;
    }

    private class MyListAdapter extends BaseAdapter {

        LayoutInflater inflater;

        public MyListAdapter() {
            inflater = LayoutInflater.from(getContext());
        }
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
                convertView = inflater.inflate(R.layout.msg_item, parent, false);
            }

            MyListItem item = (MyListItem) getItem(position);
            ((TextView)convertView.findViewById(R.id.id_msg_text)).setText(item.text);
            return convertView;
        }
    }

}
