package com.example.leo.a6_smalltask;


import android.os.Handler;
import android.os.Message;

/**
 * Created by dingdongqianbaofuyin on 2018/9/14.
 */

public abstract class SmallTast extends Thread {

    MyHander hander = new MyHander();

    // 子类需重写此方法, 此方法在线程里调用
    protected abstract Object doInBackground();

    // 子类需重写此方法, 此方法里Handler里调用，用于更新UI
    protected abstract void onPostExecute(Object result);

    public void execute() {
        start();
    }

    @Override
    public void run() {

        Object object = doInBackground();
        Message message = new Message();
        message.what = 1;
        message.obj = object;
        hander.sendMessage(message);

    }

    private class MyHander extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Object result = msg.obj;
            onPostExecute(result);
        }
    }
}
