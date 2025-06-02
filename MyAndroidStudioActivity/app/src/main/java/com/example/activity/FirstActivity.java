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

    private int imageIndex = 0; // imageIndex变量：记录当前图片索引
    private int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3}; //  images：图片资源数组

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);	// 设置当前界面使用的布局文件


        // 初始化图片控件
        imageView = findViewById(R.id.image_view);

        // 初始化所有按钮和文本框控件
        Button button1 = findViewById(R.id.first_layout_button_1); // 显式跳转页面二
        Button button2 = findViewById(R.id.first_layout_button_2); // 隐式跳转页面二
        Button button3 = findViewById(R.id.first_layout_button_3); // 打开百度网页
        Button button4 = findViewById(R.id.first_layout_button_4); // 拨打电话
        Button button5 = findViewById(R.id.first_layout_button_5); // 切换图片
        Button button6 = findViewById(R.id.first_layout_button_6); // 隐式跳转页面三
        Button button7 = findViewById(R.id.show_input_button);     // 显示输入框内容
        Button button8 = findViewById(R.id.dialog_button);         // 弹出对话框

        EditText editText = findViewById(R.id.edit_text);          // 用户输入框

        // 为按钮设置点击事件监听器
        //按钮1：显式跳转到 SecondActivity
        button1.setOnClickListener(new View.OnClickListener() {
            // 重写 onClick 方法，当按钮被点击时会调用此方法
            @Override
            public void onClick(View v) {
                //  使用 Toast 类创建一个短暂显示的消息提示，Toast.LENGTH_SHORT 的显示时长约为 2 秒。
                Toast.makeText(FirstActivity.this, "你使用显式Intent跳转到了页面2", Toast.LENGTH_SHORT).show();

                //使用显式Intent实现跳转
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        //按钮2：隐式跳转到 SecondActivity
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

        //按钮3：打开百度
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

        //按钮4：打电话
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

        //按钮5：切换图片，每点击一次切换一张图
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageIndex = (imageIndex + 1) % images.length; // 每次点击后索引 +1，超出就回到 0
                imageView.setImageResource(images[imageIndex]); // 设置当前图片
                //Toast.makeText(FirstActivity.this, "你切换到了第" + (imageIndex + 1) + "张图片", Toast.LENGTH_SHORT).show();
            }
        });

        //按钮6：隐式跳转到 ThirdActivity
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 使用隐式 Intent 跳转到 ThirdlActivity
                Toast.makeText(FirstActivity.this, "你使用隐式Intent跳转到了页面3", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent("com.example.activity.ACTION_START");
                intent.addCategory("android.intent.category.DEFAULT");
                startActivity(intent);
            }
        });


        //按钮7：读取输入框内容并显示在 Toast 中
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //收取文本框的内容
                String inputText = editText.getText().toString();
                Toast.makeText(FirstActivity.this, "你输入了: " + inputText, Toast.LENGTH_SHORT).show();
            }
        });

        //按钮8：显示弹出对话框
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
                        // 点击确认后什么也不做
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