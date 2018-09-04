package example.demo0701;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    final int REQ_GET_INPUT = 1001;
    final String TAG = "测试MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //点击对话框
    public void onDialog(View view) {

        PayDialog dlg = new PayDialog();
        dlg.show(getFragmentManager(), "PayDialog");
    }

    // 点击添加按钮
    public void onAdd ( View view)
    {
        Intent intent = new Intent(this, GetInputActivity.class);
        startActivityForResult( intent, REQ_GET_INPUT);
        Log.d(TAG, "打开一个输入界面,等待用户输入...");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        // 是否 REQ_GET_INPUT 的返回
        if (requestCode == REQ_GET_INPUT)
        {
            // 是否OK
            if (resultCode == RESULT_OK)
            {
                // 从intent中取出数据
                String name = data.getStringExtra("name");
                boolean sex = data.getBooleanExtra("sex", false);
                Log.d(TAG, "得到返回结果OK:" + name + ", " + sex);

                // 大家可以自己补充此示例，添加一个ListView
                // 再往ListView里添加一行新的输入
            }
            else
            {
                Log.d(TAG, "用户取消了输入!");
            }
        }
    }

}
