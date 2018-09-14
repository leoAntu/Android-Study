package com.example.leo.thread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final String TAG = "测试";

    MyHandle handle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handle = new MyHandle();
    }

    public void startCount(View view) {

        MyThread thread = new MyThread();
        thread.start();
    }

    private class MyThread extends Thread {
        @Override
        public void run() {
            int count = 60;
            while (count > 0) {
                Log.w(TAG,"倒计时：" + count);
                count--;

                Message message = new Message();
                message.what = 1;
                message.arg1 = count;
                handle.sendMessage(message);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private class MyHandle extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                int number = msg.arg1;
                ((TextView)findViewById(R.id.id_display)).setText(String.valueOf(number));

            }
        }
    }
}
