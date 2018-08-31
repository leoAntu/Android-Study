package example.demo0701;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class GetInputActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_input);
    }

    // 按返回按钮
    public void onBack( View view)
    {
        setResult(RESULT_CANCELED); // 设置返回码为RESULT_CANCELED
        finish();
    }

    // 按确定按钮
    public void onOK (View view)
    {
        // 取得用户输入
        String name = ((EditText)findViewById(R.id.id_name)).getText().toString();
        boolean sex = ((CheckBox)findViewById(R.id.id_sex)).isChecked();

        // 返回结果给调用者
        Intent intent = new Intent();
        intent.putExtra("name", name);
        intent.putExtra("sex", sex);
        setResult(RESULT_OK, intent); // 设置返回码为RESULT_OK

        finish();
    }
}
