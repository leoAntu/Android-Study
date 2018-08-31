package example.demo0405;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity
{

    // 数据源
    ArrayList<Student> listData = new ArrayList();

    // 注：不要写成 MyListAdapter listAdapter = = new MyListAdapter()
    // 必须在界面初始化完成之后再创建 MyListAdapter，因为MyListAdapter的构造方法里调用了getDrawable()
    MyListAdapter listAdapter;

    // 是否多选模式
    boolean selectMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 准备数据
        listData.add(new Student("Zhang Liang", true, 90));
        listData.add(new Student("Han Xin", true, 100));
        listData.add(new Student("Xiao He", true, 80));
        listData.add(new Student("Chen Ping", true, 75));

        // 准备数据适配器
        listAdapter = new MyListAdapter();

        // 获取ListView
        ListView listView = (ListView) findViewById(R.id.id_listview);
        listView.setAdapter(listAdapter); // 设置适配器

        // ListView事件处理
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_SHORT).show();
                if(selectMode)
                {
                    Student s = (Student) listAdapter.getItem(position);
                    s.selected = ! s.selected; // 选中，或取消选中
                    listAdapter.notifyDataSetChanged(); // 刷新显示(此处可以优化)
                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(MainActivity.this, "长按", Toast.LENGTH_SHORT).show();
                // 进入选择模式
                selectMode = true;
                // 选中这一项
                Student s = (Student) listAdapter.getItem(position);
                s.selected = true;
                listAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    // 点击“取消”按钮时，退出选择模式
    public void cancelSelecting(View view)
    {
        // 清除选中状态
        for(Student s: listData)
        {
            s.selected = false;
        }
        // 退出选择模式
        selectMode = false;
        // 刷新显示
        listAdapter.notifyDataSetChanged();
    }

    // 点击“删除”按钮时，删除选中项
    public void removeSelected(View view)
    {
        Iterator<Student> iter = listData.iterator();
        while(iter.hasNext())
        {
            Student s = iter.next();
            if(s.selected)
                iter.remove();
        }
        selectMode = false;
        listAdapter.notifyDataSetChanged();
    }

    /////////////////////////////////////
    public class Student
    {
        public String name;
        public boolean sex;
        public int score;
        public boolean selected; // 是否选中
        public Student(String name, boolean sex, int score)
        {
            this.name = name;
            this.sex = sex;
            this.score = score;
        }
    }


    //////// 定义适配器 //////////////////
    private class MyListAdapter extends BaseAdapter
    {
        // 男女图标
        Drawable[] icons = new Drawable[2];

        // 数据副本
        ArrayList<Student> dataCopy = new ArrayList();

        // 选中图标
        Drawable[] iconsSel = new Drawable[2];

        public MyListAdapter()
        {
            dataCopy = listData;
            icons[0] = MainActivity.this.getDrawable(R.drawable.ic_female);
            icons[1] = getDrawable(R.drawable.ic_male);

            iconsSel[0] = getDrawable(R.drawable.ic_unchecked);
            iconsSel[1] = getDrawable(R.drawable.ic_checked);
        }

        @Override
        public int getCount()
        {
            return dataCopy.size();
        }

        @Override
        public Object getItem(int position)
        {
            return dataCopy.get( position);
        }

        @Override
        public long getItemId(int position)
        {
            return position; // 如果不懂，先跳过
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            // 创建控件
            if (convertView == null)
            {
                convertView = getLayoutInflater()
                        .inflate(R.layout.list_item_student, parent, false);
            }
            // 获取数据
            Student data = (Student) getItem(position);
            // 显示数据
            TextView textView = (TextView) convertView.findViewById(R.id.id_textview);
            textView.setText(data.name + "(" + data.score + ")");
            ImageView imageView = (ImageView)convertView.findViewById(R.id.id_imageview);
            if (data.sex)
                imageView.setImageDrawable(icons[1]);
            else
                imageView.setImageDrawable(icons[0]);

            // 选择模式
            imageView = (ImageView) convertView.findViewById(R.id.id_icon_select);
            if( !selectMode)
            {
                imageView.setVisibility(View.GONE);
            }
            else
            {
                imageView.setVisibility(View.VISIBLE);
                if(data.selected)
                    imageView.setImageDrawable(iconsSel[1]);
                else
                    imageView.setImageDrawable(iconsSel[0]);

            }
            return convertView;

        }
    }
}
