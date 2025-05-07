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
        setContentView(R.layout.third_layout);

        // 初始化按钮
        Button button1 = findViewById(R.id.third_layout_button1);
        Button button2 = findViewById(R.id.third_layout_button2);

        // 按钮1：跳转到页面1
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, "你使用显式Intent跳转回到了页面1", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ThirdActivity.this, FirstActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        // 按钮2：跳转到页面2
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, "你使用显式Intent跳转到了页面2", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent("com.example.activity.SECOND_ACTION");
                intent.addCategory("android.intent.category.DEFAULT");
                // 限定只在本 app 内查找
                intent.setPackage(getPackageName());
                startActivity(intent);
            }
        });

        // ListView 显示数据
        List<Instruments> instrumentList = new ArrayList<>();
        instrumentList.add(new Instruments("Guitar", R.drawable.guitar));
        instrumentList.add(new Instruments("Bass", R.drawable.bass));
        instrumentList.add(new Instruments("Drum_Set", R.drawable.drum_set));
        instrumentList.add(new Instruments("Piano_Keys", R.drawable.piano_keys));
        instrumentList.add(new Instruments("Microphone", R.drawable.microphone));

        InstrumentsAdapter adapter = new InstrumentsAdapter(ThirdActivity.this,
                R.layout.instruments_item, instrumentList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        //listview的点击事件  setOnItemClickListener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Instruments instruments = instrumentList.get(position);
                Toast.makeText(ThirdActivity.this, instruments.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}