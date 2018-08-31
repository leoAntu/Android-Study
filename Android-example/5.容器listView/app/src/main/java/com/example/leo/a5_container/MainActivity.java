package com.example.leo.a5_container;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> listData = new ArrayList();
    MyListAdapter listAdapter; //必须在onCreate中new一个对象
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        创建数据源
        listData.add(new Student("小张", true, 80));
        listData.add(new Student("小王", false,90));
        listData.add(new Student("小李", true,50));

//        准备数据适配器
        listAdapter = new MyListAdapter();

//        获取listview
        final ListView listView = (ListView)findViewById(R.id.id_listView);
        listView.setAdapter(listAdapter);
//        cell点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = (Student) listAdapter.getItem(position);
                String string = "点击了" + student.name;
                Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        });
//        长按事件
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "长按了" + position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

//    按名字排序事件
    public void  sortByName(View view) {

        listAdapter.sortByName();
    }
//    按分数排序事件
    public void  sortByScore(View view) {
        listAdapter.sortByScore();
    }
// 添加按钮事件
    public void onClick(View view) {
        EditText editText = (EditText)findViewById(R.id.id_edit);
        String name = editText.getText().toString();

        //添加一条记录
        Student student = new Student(name, false,88);
        listData.add(0,student);

        //刷新listview的适配器刷新
        listAdapter.dataCopy = new ArrayList(listData);
        listAdapter.notifyDataSetChanged();
    }
//    创建一个内部类 student
    private class  Student {
        public String name;
        public boolean sex;
        public int point;
        public Student(String name, boolean sex, int point) {
            this.name = name;
            this.sex = sex;
            this.point = point;
        }
    }

//    创建一个内部类，适配器
    private class MyListAdapter extends BaseAdapter {

    // 男女图标 
       Drawable[] icons = new Drawable[2];
       ArrayList<Student> dataCopy = new ArrayList();

       public  MyListAdapter() {
           dataCopy = listData;
           icons[0] = getDrawable(R.drawable.image1);
           icons[1] = getDrawable(R.drawable.famale2);
       }

       public void sortByName() {
           dataCopy = new ArrayList(listData);
           Collections.sort(dataCopy,new Comparator<Student>() {

               @Override
               public int compare(Student o1, Student o2) {
                   return o1.name.compareTo(o2.name);
               }
           });

           notifyDataSetChanged();
       }

    public void sortByScore() {
        dataCopy = new ArrayList(listData);
        Collections.sort(dataCopy,new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.point > o2.point) return 1;
                else if(o1.point== o2.point) return 0;
                else return -1;
            }
        });
        notifyDataSetChanged();
    }

        @Override
        public int getCount() {
            return dataCopy.size();
        }

        @Override
        public Object getItem(int position) {
            return dataCopy.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//           创建控件
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item_student, parent,false);
            }
//            获取数据
            Student data = (Student)getItem(position);
//            显示数据
            TextView textView = (TextView)convertView.findViewById(R.id.id_textView);
            String text = data.name + "(" + data.point + ")";

            textView.setText(text);
            ImageView imageView = (ImageView)convertView.findViewById(R.id.id_imageView);
            if (data.sex) {
                imageView.setImageDrawable(icons[1]);
            } else {
                imageView.setImageDrawable(icons[0]);
            }
            return convertView;
        }
}
}
