package com.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  setContentView 是 Activity 类中的一个重要方法 ，它的作用是为当前 Activity 设置要显示的用户界面布局。
        //  R 是一个自动生成的资源类，它包含了项目中所有资源（如布局、字符串、图片等）的标识符。
        //  layout 是资源目录名，用于存放布局文件。
        //  first_layout 是具体的布局文件名，这个布局文件定义了界面的视图结构和外观。
        setContentView(R.layout.first_layout);

        //  button1按钮点击后使用toast弹出消息
        //  通过 findViewById 方法找到布局中 id 为 btn1 的按钮，并将其强制转换为 Button 类型
        Button button1 = findViewById(R.id.btn1);

        // 为按钮设置点击事件监听器
        button1.setOnClickListener(new View.OnClickListener() {
            // 重写 onClick 方法，当按钮被点击时会调用此方法
            @Override
            public void onClick(View v) {
                //  使用 Toast 类创建一个短暂显示的消息提示，Toast.LENGTH_SHORT 的显示时长约为 2 秒。
                Toast.makeText(FirstActivity.this, "你点击了按钮", Toast.LENGTH_SHORT).show();

                //使用显式Intent实现跳转
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        //
    }

    //	菜单栏部分
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // 菜单响应事件
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_item) {
            Toast.makeText(this, "你点击了添加", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.remove_item) {
            Toast.makeText(this, "你点击了删除", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}