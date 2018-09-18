package com.example.leo.a6_smalltask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    CustomDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doSave(View view) {

        String content = ((EditText)findViewById(R.id.id_edittext)).getText().toString();
        if (content.length() == 0) {
            Toast.makeText(this, "请输入保存的信息", Toast.LENGTH_SHORT).show();
            return;
        }

        dialog = new CustomDialog();
        dialog.show(this,view);

        //创建线程
//        MyTask task = new MyTask(content);
//        task.execute();

        //系统Task
        MyAyscTask ayscTask = new MyAyscTask(content);
        ayscTask.execute();
    }

    private void saveContent(String text) throws Exception {
        File dataDir = getExternalFilesDir("data");
        File f = new File(dataDir, "example.txt");
        FileOutputStream fstream = null;
        try{
            fstream = new FileOutputStream(f);
            fstream.write(text.getBytes("UTF-8"));
        }finally
        {
            try{ fstream.close();}catch (Exception e){}
        }
    }

    //系统自带线程

    private class MyAyscTask extends AsyncTask {
        String content;
        public MyAyscTask(String content) {
            this.content = content;
        }
        @Override
        protected Object doInBackground(Object[] objects) {
            //执行异步任务
            try {
                saveContent(content);
                Thread.sleep(2000);//延时2s
            } catch (Exception e) {}
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            dialog.dismiss();
            Toast.makeText(MainActivity.this, "保存成功!", Toast.LENGTH_SHORT).show();
        }
    }

    //自定义线程
    private class MyTask extends SmallTast {

        String content;
        public MyTask(String content) {
            this.content = content;
        }
        @Override
        protected Object doInBackground() {
            //执行异步任务
            try {
                saveContent(content);
                Thread.sleep(2000);//延时2s
            } catch (Exception e) {
            }

            return null;
        }

        @Override
        protected void onPostExecute(Object result) {
            dialog.dismiss();
            Toast.makeText(MainActivity.this, "保存成功!", Toast.LENGTH_SHORT).show();
        }
    }
}
