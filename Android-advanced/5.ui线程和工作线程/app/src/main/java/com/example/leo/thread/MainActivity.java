package com.example.leo.thread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final String TAG = "测试";
    boolean started = false; // 是否正在计时
    MyHandle handle;
    MyThread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handle = new MyHandle();
    }

    public void startCount(View view) {

        if (!started) {
            ((Button)findViewById(R.id.id_button_start)).setText("停止");
            thread = new MyThread();
            thread.doStart();
            started = true;
        } else  {
            ((Button)findViewById(R.id.id_button_start)).setText("开始");
            thread.doStop();
            started = false;

        }
    }

    private class MyThread extends Thread {
        boolean quitflag = false;

        public void doStart() {
            start();
        }

        // 停止线程
        public void doStop()
        {
            quitflag = true;
            this.interrupt();
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {

            long startTime = System.currentTimeMillis();
            while (!quitflag) {
                // 计算时差
                long now = System.currentTimeMillis();
                int duration = (int)(now - startTime);

                // 发送消息
                Message msg = new Message();
                msg.what = 1;
                msg.arg1 = duration; // arg1表示时差
                handle.sendMessage(msg);

                // 每0.1秒刷新一次
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {
                    break; // 外部调用interrupt()时抛此异常
                }
            }
        }
    }

    private void showTime(int duration) {
        //毫秒
        int ms = duration % 1000;
        int seconds = duration / 1000;

        //转成 MM:SS显示
        int ss = seconds % 60;
        int mm = seconds / 60;
        String text = String.format("%2d:%2d.%2d",mm,ss,ms/10);
        ((TextView)findViewById(R.id.id_display)).setText( text );
    }

    private class MyHandle extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                // 从消息里取出参数
                int duration = msg.arg1;
                showTime(duration);
            }
            super.handleMessage(msg);
        }
    }
}
