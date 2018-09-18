package com.example.leo.a1_timer;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.SimpleFormatter;

public class MainActivity extends AppCompatActivity {

    MyHandle handle = new MyHandle();
    MyTimerTask timerTask = new MyTimerTask();
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startTimer();
    }

    @Override
    protected void onDestroy() {

        stopTimer();
        super.onDestroy();
    }

    private void startTimer() {
        if (timer != null) {
            return;
        }
        timer = new Timer();
        timer.schedule(timerTask,500,500); //500ms执行一次
    }

    private void stopTimer() {

        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    private class MyTimerTask extends TimerTask {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        @Override
        public void run() {
            String timeStr = sdf.format(System.currentTimeMillis());
            Message message = new Message();
            message.what = 1;
            message.obj = timeStr;
            handle.sendMessage(message);
        }
    }

    private class MyHandle extends android.os.Handler {
        @Override
        public void handleMessage(Message msg) {
            String timeStr = (String) msg.obj;
            ((TextView)findViewById(R.id.id_text)).setText(timeStr);
        }
    }
}
