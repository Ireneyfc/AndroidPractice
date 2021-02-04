package com.example.uiwidgettest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                //点击按钮出现ProgressDialog
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");       
                progressDialog.setCancelable(true);
                progressDialog.show();
//                //点击按钮出现AlertDialog
//                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//                dialog.setTitle("This is a Dialog");
//                dialog.setMessage("Something important");
//                dialog.setCancelable(false);//不可用Back键关闭对话框
//                //设置点击OK
//                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                //设置点击Cancle
//                dialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                dialog.show();

//                //点击按钮进度条更新
//                int progress = progressBar.getProgress();
//                progress += 10;
//                progressBar.setProgress(progressl);
//                //点击按钮控制进度条可见性
//                if(progressBar.getVisibility()==View.GONE){
//                    progressBar.setVisibility(View.VISIBLE);
//                }else{
//                    progressBar.setVisibility(View.GONE );
//                }
//                //点击按钮更换图片
//                imageView.setImageResource(R.drawable.img_2);
//                //点击按钮获取输入内容
//                String inputTest = editText.getText().toString();
//                Toast.makeText(MainActivity.this, inputTest, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}