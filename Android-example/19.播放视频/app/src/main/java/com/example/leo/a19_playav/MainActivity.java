package com.example.leo.a19_playav;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    final String TAG = "测试 PlayerActivity";

    final static int REQ_OPEN_FILE = 1001;
    VideoView videoView;
    SeekBar seekBar; // 可拖放进度条
    Handler msgHandler; // Android消息机制 (高级篇讲解)

    Timer timer;
    TimerTask timerTask;

    View viewBar; //控制面板

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题 
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏 


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //动态申请权限
        Permissions.check(this);
        //获取video
        videoView = findViewById(R.id.id_videoView);
        //获取seekBar
        seekBar = findViewById(R.id.id_seekBar);
        seekBar.setMax(100);

        //消息支持
        msgHandler = new MyHandler();

        //播放按钮
        final ImageButton imageButton = findViewById(R.id.id_imageBtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoView.isPlaying()) {
                    Log.d(TAG, "正在播放，现在暂停...");
                    videoView.pause();
                    imageButton.setImageDrawable(getDrawable(R.drawable.ic_play));
                } else  {
                    Log.d(TAG, "不在播放，现在继续...");
                    videoView.start();
                    imageButton.setImageDrawable(getDrawable(R.drawable.ic_pause));
                }
            }
        });

        //播放控制
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                int position = progress * videoView.getDuration() / 100;
                videoView.seekTo(position);
//                if (videoView.isPlaying()) {
//                    int progress = seekBar.getProgress();
//                    int position = progress * videoView.getDuration() / 100;
//                    videoView.seekTo(position);
//                }
            }
        });

        //控制面板
        viewBar = findViewById(R.id.id_controlBar);
        //给video添加touch事件
        videoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (viewBar.getVisibility() == View.GONE) {
                    viewBar.setVisibility(View.VISIBLE);
                } else {
                    viewBar.setVisibility(View.GONE);
                }
                return false;
            }
        });

        // 接受外部调用
        Intent intent = getIntent();
        Uri mediaUri = intent.getData();
        if(mediaUri != null)
        {
            videoView.setVideoURI(mediaUri);
            videoView.start();
        }
    }

    @Override
    protected void onStart() {
        //必须放在super.onStart之前 ,进来强制设置横屏
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onStart();
        if (timer == null) {
            timerTask = new MyTimerTask();
            timer = new Timer();
            timer.schedule(timerTask,500,500);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (timer != null) {
            //本界面隐藏时，要停止定时器（因为本界面已经隐藏了，如果继续刷新界面将毫无意义、白白耗费CPU)
            timer.cancel();
            timer = null;
        }
    }

    public void openFile(View view) {

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("video/*");//只显示视频
        startActivityForResult(intent, REQ_OPEN_FILE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != REQ_OPEN_FILE) return;
        if (resultCode != RESULT_OK) return;

        Uri uri = data.getData();
        videoView.setVideoURI(uri);
        videoView.start();
    }

    //显示进度条
    public void  showProgress(int duration, int position) {
        int percent = position * 100 / duration;
        seekBar.setProgress(percent);
    }

    //消息支持
    private class  MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                int duration = msg.arg1;
                int position = msg.arg2;
                showProgress(duration,position);
            }
        }
    }

    //定时器类
    private class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            if (!videoView.isPlaying()) return;

            //取得当前的进度
            int duration = videoView.getDuration();
            int position = videoView.getCurrentPosition();
            // 注意：在工作线程里不能直接更新UI，必须发消息给UI线程，然后在Handler里处理

            //发送消息给UI
            Message message = new Message();
            message.what = 1; //类型
            message.arg1 = duration; //第一个参数
            message.arg2 = position; //第二个参数
            msgHandler.sendMessage(message);
        }
    }
}
