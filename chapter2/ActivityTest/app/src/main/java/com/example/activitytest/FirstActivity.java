package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity", "Task id is" + getTaskId());//活动的启动模式singleInstance
//        Log.d("FirstActivity",this.toString());//活动的启动模式前三种
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //启动活动的最佳写法,当启动活动需要传递数据时
                SecondActivity.actionStart(FirstActivity.this, "data1", "data2");
            }
//            public void onClick(View v) {//活动的启动模式：singleTop,singleTask，singleInstance
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                startActivity(intent);
//            }
//            public void onClick(View v) {//活动的启动模式：Standard
//                Intent intent = new Intent(FirstActivity.this, FirstActivity.class);
//                startActivity(intent);
//            }
//            public void onClick(View v) {//返回数据给上一个活动
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                startActivityForResult(intent,1);
//            }
//            public void onClick(View v) {//向下一个活动传递数据
//                String data = "hello yfc";
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                intent.putExtra("extra_data", data);
//                startActivity(intent);
//            }
//            public void onClick(View v) {//更多隐式Intent，拨打电话
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:13571452002"));
//                startActivity(intent);
//
//            }
//            public void onClick(View v) {//更多隐式Intent，打开系统浏览器
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
//                startActivity(intent);
//
//            }
//            public void onClick(View v) {//隐式Intent
//                Intent intent = new Intent("com.example.activitytest.ACTION_START");
//                intent.addCategory("com.example.activitytest.MY_CATEGORY");
//                startActivity(intent);
//
//            }
//            public void onClick(View v) {//显式Intent
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                startActivity(intent);
//
//            }
//            public void onClick(View v) {//销毁一个活动
//                finish();
//            }
//            public void onClick(View v) {
//                Toast.makeText(FirstActivity.this,
//                        "You clicked Button 1", Toast.LENGTH_SHORT).show();
//            }

        });
    }

    @Override
    //返回数据给上一个活动
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }
    }

    @Override
    //import android.view.Menu;
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override//import android.view.MenuItem;
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onRestart() {//活动的启动模式：singleTask
        super.onRestart();
        Log.d("FirstActivity", "onRestart");
    }


}