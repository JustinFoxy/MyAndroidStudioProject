package com.example.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        //按钮初始化
        Button button1 = findViewById(R.id.second_layout_button_1);
        Button button2 = findViewById(R.id.show_input_button);
        Button button3 = findViewById(R.id.dialog_button);
        //文本框初始化
        EditText editText = findViewById(R.id.edit_text);


        //按钮1
        button1.setOnClickListener(new View.OnClickListener() {
            // 重写 onClick 方法，当按钮被点击时会调用此方法
            @Override
            public void onClick(View v) {
                //  使用 Toast 类创建一个短暂显示的消息提示，Toast.LENGTH_SHORT 的显示时长约为 2 秒。
                Toast.makeText(SecondActivity.this, "你使用隐式Intent跳转回到了页面1", Toast.LENGTH_SHORT).show();

                // 使用显式 Intent 跳转回 FirstActivity
                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // 如果页面1已打开，返回原页面而不是创建新实例
                startActivity(intent);
            }
        });


        //按钮2
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //收取文本框的内容
                String inputText = editText.getText().toString();
                Toast.makeText(SecondActivity.this, "你输入了: " + inputText, Toast.LENGTH_SHORT).show();
            }
        });

        //按钮3
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳出弹窗
                AlertDialog.Builder dialog = new AlertDialog.Builder(SecondActivity.this);
                dialog.setTitle("有一个重要的信息");
                dialog.setMessage("求求老师大作业给我过吧");
                dialog.setCancelable(false);
                dialog.setPositiveButton("让我过！", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        });


    }

}