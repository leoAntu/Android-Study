package com.example.leo.a3_mutilsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MyListItem> listData = new ArrayList();

    MyListAdapter listAdapter;

    //所有过滤条件
    ComboxList.Option[] optionsA = new ComboxList.Option[3];
    ComboxList.Option[] optionsB = new ComboxList.Option[4];

    // 当前过滤条件
    ComboxList.Option filter1, filter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 过滤条件
        optionsA[0] = new ComboxList.Option("性别:不限", "all", null);
        optionsA[1] = new ComboxList.Option("男", "male", null);
        optionsA[2] = new ComboxList.Option("女", "female", null);

        optionsB[0] = new ComboxList.Option("年龄:不限", "all", null);
        optionsB[1] = new ComboxList.Option("<18岁", "lt18", null);
        optionsB[2] = new ComboxList.Option("18-20岁", "18-20", null);
        optionsB[3] = new ComboxList.Option(">20岁", "gt20", null);

        filter1 = optionsA[0];
        filter2 = optionsB[0];

        //初始化数据
        initListData();

        listAdapter = new MyListAdapter();
        ListView listView = (ListView) findViewById(R.id.id_listView);
        listView.setAdapter(listAdapter);

        //初始化显示条件
        showFilters();
    }

    // 演示数据
    private void initListData() {
        listData.add(new MyListItem("赵",true, 17));
        listData.add(new MyListItem("钱",true, 24));
        listData.add(new MyListItem("孙",false, 22));
        listData.add(new MyListItem("李",true, 18));
        listData.add(new MyListItem("周",false, 19));
        listData.add(new MyListItem("吴",true, 19));
        listData.add(new MyListItem("郑",true, 21));
        listData.add(new MyListItem("王",true, 18));
    }

    public void changeFilter1(View view) {
        ComboxList comboxList = createCombox(optionsA,view);
        comboxList.listener = new ComboxList.OnComboxListListener() {
            @Override
            public void OnItemClickedListener(ComboxList.Option option) {
                filter1 = option;
                showFilters();
            }
        };
    }

    public void changeFilter2(View view) {
        ComboxList comboxList = createCombox(optionsB,view);
        comboxList.listener = new ComboxList.OnComboxListListener() {
            @Override
            public void OnItemClickedListener(ComboxList.Option option) {
                filter2 = option;
                showFilters();
            }
        };
    }

    private ComboxList createCombox(ComboxList.Option[] options, View view) {
        ComboxList comboxList = new ComboxList();
        comboxList.addOptions(options);
        comboxList.show(this,view,0,0);
        return comboxList;
    }

    // 显示当前过滤条件
    private void showFilters() {
        ((TextView)findViewById(R.id.id_search_sex)).setText(filter1.name);
        ((TextView)findViewById(R.id.id_search_age)).setText(filter2.name);

        listAdapter.doFilter();
    }

    ///////////// 每一条记录的数据 /////////
    private static class MyListItem
    {
        public String name;
        public boolean sex;
        public int age;
        public MyListItem(){}
        public MyListItem(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
    }

    private class MyListAdapter extends BaseAdapter {
        ArrayList<MyListItem> listCopy = new ArrayList();

        public void doFilter() {
            listCopy.clear();

            for (MyListItem item : listData) {
                //按性别过滤
                if (filter1.value.equals("male")) {
                    if (item.sex != true) continue;
                } else if (filter1.value.equals("female")) {
                    if (item.sex == true) continue;
                }

                //按年龄过滤
                if(filter2.value.equals("lt18"))
                {
                    if(item.age >= 18) continue;
                }
                else if(filter2.value.equals("18-20"))
                {
                    if(item.age<18 || item.age>20) continue;
                }
                else if(filter2.value.equals("gt20"))
                {
                    if(item.age <=20) continue;
                }
                listCopy.add(item);
            }

            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return listCopy.size();
        }

        @Override
        public Object getItem(int position) {
            return listCopy.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item_student, parent, false);
            }

            MyListItem item = (MyListItem) getItem(position);
            ((TextView)convertView.findViewById(R.id.id_item_name)).setText(item.name);
            ((TextView)convertView.findViewById(R.id.id_item_sex)).setText(item.sex ? "男":"女");
            ((TextView)convertView.findViewById(R.id.id_item_old)).setText(item.age + "岁");

            return convertView;
        }
    }

}
