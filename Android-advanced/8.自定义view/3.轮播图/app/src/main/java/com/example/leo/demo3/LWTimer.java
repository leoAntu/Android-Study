package com.example.leo.demo3;

import android.os.Handler;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by dingdongqianbaofuyin on 2018/9/17.
 */

public abstract class LWTimer {
    private Timer timer;
    private MyHandle handler = new MyHandle();
    private MyTimerTask task = new MyTimerTask();

    // 子类需重写此方法, 此方法在线程里调用
    protected abstract Object doInBackground();

    // 子类需重写此方法, 此方法里Handler里调用，用于更新UI
    // 此方法需要尽快完成, 否则会引起界面卡顿
    protected abstract void onPostExecute(Object result);

    public LWTimer(){

    }

    public void schedule(int interval) {
        if (timer != null) return;
        timer = new Timer();
        timer.schedule(task,interval,interval);
    }

    private class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            Object result = doInBackground();
            Message message = new Message();
            message.what = 1;
            message.obj = result;
            handler.handleMessage(message);
        }
    }

    private class MyHandle extends Handler{
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                Object o = msg.obj;
                onPostExecute(0);
            }
        }
    }
}
