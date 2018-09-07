package com.example.leo.a2wechatpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    Fragment[] pages = new Fragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设置viewPager
        pages[0] = new MsgFragment();
        pages[1] = new CCFragment();
        pages[2] = new UserFragment();

        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager());
        final ViewPager pager = (ViewPager)findViewById(R.id.id_viewpager);
        pager.setAdapter(adapter);


        //设置标签页
        TabBarAdapter.Item[] labels = new TabBarAdapter.Item[3];
        labels[0] = new TabBarAdapter.Item("微信","msg");
        labels[0].iconNormal = getDrawable(R.drawable.ic_msg_normal);
        labels[0].iconActive = getDrawable(R.drawable.ic_msg_active);
        labels[1] = new TabBarAdapter.Item("发现","cc");
        labels[1].iconNormal = getDrawable(R.drawable.ic_find_normal);
        labels[1].iconActive = getDrawable(R.drawable.ic_find_active);
        labels[2] = new TabBarAdapter.Item("我","user");
        labels[2].iconNormal = getDrawable(R.drawable.ic_user_normal);
        labels[2].iconActive = getDrawable(R.drawable.ic_user_active);

        final TabBarAdapter tabBarAdapter = new TabBarAdapter(this);
        tabBarAdapter.addItems(labels);

        GridView gridView = findViewById(R.id.id_gridView);
        gridView.setAdapter(tabBarAdapter);
        gridView.setNumColumns(labels.length);
        tabBarAdapter.setActive(0,true);

        //监听事件
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pager.setCurrentItem(position);
                tabBarAdapter.setActive(position,true);
            }
        });

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabBarAdapter.setActive(position,true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private class MyFragmentAdapter extends FragmentPagerAdapter {

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return pages[position];
        }

        @Override
        public int getCount() {
            return pages.length;
        }
    }

}
