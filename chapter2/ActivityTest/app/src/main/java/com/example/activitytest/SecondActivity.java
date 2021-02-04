package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Context;

public class SecondActivity extends BaseActivity {
    //启动活动的最佳写法
    public static void actionStart(Context context, String data1, String data2) {//import android.content.Context;
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecondActivity", "Task id is" + getTaskId());//活动的启动模式singleInstance
//        Log.d("SecondActivity", this.toString());//活动的启动模式
        setContentView(R.layout.second_layout);
//        //向下一个活动传递数据
//        Intent intent = getIntent();
//        String data = intent.getStringExtra("extra_data");
//        Log.d("SecondActivity", data);

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//活动的启动模式singleInstance
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
//            public void onClick(View v) {//活动的启动模式:singleTop
//                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
//                startActivity(intent);
//            }
//            public void onClick(View v) {//返回数据给上一个活动
//                Intent intent = new Intent();
//                intent.putExtra("data_return","I'm a message from button2");
//                setResult(RESULT_OK,intent);
//                finish();
//            }
        });
    }

    //返回数据给上一个活动
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "I'm a message from button2");
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onDestroy() {//活动的启动模式：singleTask
        super.onDestroy();
        Log.d("SecondActivity", "onDestroy");
    }
}                        