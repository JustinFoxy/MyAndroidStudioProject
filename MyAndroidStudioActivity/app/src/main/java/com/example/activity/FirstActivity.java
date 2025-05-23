package com.example.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    private ImageView imageView;

    private int imageIndex = 0; // imageIndex变量记录当前图片索引
    private int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3}; // 图片资源数组

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  setContentView 是 Activity 类中的一个重要方法 ，它的作用是为当前 Activity 设置要显示的用户界面布局。
        //  R 是一个自动生成的资源类，它包含了项目中所有资源（如布局、字符串、图片等）的标识符。
        //  layout 是资源目录名，用于存放布局文件。
        //  first_layout 是具体的布局文件名，这个布局文件定义了界面的视图结构和外观。
        setContentView(R.layout.first_layout);


        //  通过布局文件中的 ID 找到对应的 ImageView 控件，并赋值给变量 imageView，以便后续操作它
        imageView = (ImageView) findViewById(R.id.image_view);


        //按钮部分
        // 1️⃣通过 findViewById 方法找到布局中 id 为 first_layout_button_n 的按钮，并将其强制转换为 Button 类型
        Button button1 = findViewById(R.id.first_layout_button_1);
        Button button2 = findViewById(R.id.first_layout_button_2);
        Button button3 = findViewById(R.id.first_layout_button_3);
        Button button4 = findViewById(R.id.first_layout_button_4);
        Button button5 = findViewById(R.id.first_layout_button_5);
        Button button6 = findViewById(R.id.first_layout_button_6);
        Button button7 = findViewById(R.id.show_input_button);
        Button button8 = findViewById(R.id.dialog_button);


        EditText editText = findViewById(R.id.edit_text);

        // 2️⃣为按钮设置点击事件监听器
        //按钮1
        button1.setOnClickListener(new View.OnClickListener() {
            // 重写 onClick 方法，当按钮被点击时会调用此方法
            @Override
            public void onClick(View v) {
                //  使用 Toast 类创建一个短暂显示的消息提示，Toast.LENGTH_SHORT 的显示时长约为 2 秒。
                Toast.makeText(FirstActivity.this, "你使用显式Intent跳转到了页面2", Toast.LENGTH_SHORT).show();

                //  跳转（二选一）显式Intent和隐式Intent
                //使用显式Intent实现跳转
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        //按钮2
        button2.setOnClickListener(new View.OnClickListener() {
            // 重写 onClick 方法，当按钮被点击时会调用此方法
            @Override
            public void onClick(View v) {
                //  使用 Toast 类创建一个短暂显示的消息提示，Toast.LENGTH_SHORT 的显示时长约为 2 秒。
                Toast.makeText(FirstActivity.this, "你使用隐式Intent跳转到了页面2", Toast.LENGTH_SHORT).show();

                //使用隐式Intent实现跳转
                Intent intent1 = new Intent("com.example.activity.ACTION_START");
                intent1.addCategory("com.example.activity.My_Category");
                startActivity(intent1);
            }
        });

        //按钮3
        button3.setOnClickListener(new View.OnClickListener() {
            // 重写 onClick 方法，当按钮被点击时会调用此方法
            @Override
            public void onClick(View v) {
                //  使用 Toast 类创建一个短暂显示的消息提示，Toast.LENGTH_SHORT 的显示时长约为 2 秒。
                Toast.makeText(FirstActivity.this, "你打开了百度", Toast.LENGTH_SHORT).show();

                //使用Intent实现打开百度
                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent2);
            }
        });

        //按钮4
        button4.setOnClickListener(new View.OnClickListener() {
            // 重写 onClick 方法，当按钮被点击时会调用此方法
            @Override
            public void onClick(View v) {
                //  使用 Toast 类创建一个短暂显示的消息提示，Toast.LENGTH_SHORT 的显示时长约为 2 秒。
                Toast.makeText(FirstActivity.this, "你打开了打电话", Toast.LENGTH_SHORT).show();

                //使用Intent实现打开电话
                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("tel:18001830029"));
                startActivity(intent2);
            }
        });

        //按钮5
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageIndex = (imageIndex + 1) % images.length; // 每次点击后索引 +1，超出就回到 0
                imageView.setImageResource(images[imageIndex]); // 设置当前图片
                //Toast.makeText(FirstActivity.this, "你切换到了第" + (imageIndex + 1) + "张图片", Toast.LENGTH_SHORT).show();
            }
        });

        //按钮6

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 使用隐式 Intent 跳转到 ThirdActivity
                Toast.makeText(FirstActivity.this, "你使用隐式Intent跳转到了页面3", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent("com.example.activity.ACTION_START");
                intent.addCategory("android.intent.category.DEFAULT");
                startActivity(intent);
            }
        });


        //按钮7
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //收取文本框的内容
                String inputText = editText.getText().toString();
                Toast.makeText(FirstActivity.this, "你输入了: " + inputText, Toast.LENGTH_SHORT).show();
            }
        });

        //按钮8
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳出弹窗
                AlertDialog.Builder dialog = new AlertDialog.Builder(FirstActivity.this);
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