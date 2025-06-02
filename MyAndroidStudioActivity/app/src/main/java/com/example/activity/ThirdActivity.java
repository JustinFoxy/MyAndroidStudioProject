package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout); // 设置布局文件

        // 初始化两个跳转按钮
        Button button1 = findViewById(R.id.third_layout_button1); // 跳转到页面1
        Button button2 = findViewById(R.id.third_layout_button2); // 跳转到页面2

        // 按钮1：显式 Intent 跳转回 FirstActivity（页面1）
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, "你使用显式Intent跳转回到了页面1", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ThirdActivity.this, FirstActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // 清除回退栈中页面1之上的页面
                startActivity(intent);
            }
        });

        // 按钮2：显式 Intent 跳转到 SecondActivity（页面2）
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, "你使用显式Intent跳转到了页面2", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent("com.example.activity.SECOND_ACTION");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setPackage(getPackageName()); // 限定仅在当前 app 内查找匹配的 activity
                startActivity(intent);
            }
        });

        // 准备 ListView 中的数据（乐器列表）
        List<Instruments> instrumentList = new ArrayList<>();
        instrumentList.add(new Instruments("Guitar", R.drawable.guitar));
        instrumentList.add(new Instruments("Bass", R.drawable.bass));
        instrumentList.add(new Instruments("Drum_Set", R.drawable.drum_set));
        instrumentList.add(new Instruments("Piano_Keys", R.drawable.piano_keys));
        instrumentList.add(new Instruments("Microphone", R.drawable.microphone));

        // 创建自定义适配器，将数据绑定到 ListView 上
        InstrumentsAdapter adapter = new InstrumentsAdapter(ThirdActivity.this,
                R.layout.instruments_item, instrumentList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        //listview的点击事件：点击某项后弹出对应名称的 Toast
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Instruments instruments = instrumentList.get(position);
                Toast.makeText(ThirdActivity.this, instruments.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}