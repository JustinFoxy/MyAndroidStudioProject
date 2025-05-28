package com.example.activity;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    //初始化数据库
    private MyDatabaseHelper dbHelper;
    private ArrayAdapter<String> adapter;
    private List<String> bookList = new ArrayList<>();
    private String originalBookName = null;



    // 辅助类：存储完整信息
    static class Book {
        String name;
        String author;
        double price;
        int pages;

        Book(String name, String author, double price, int pages) {
            this.name = name;
            this.author = author;
            this.price = price;
            this.pages = pages;
        }

        //重写Book的toString方法
        @Override
        public String toString() {
            return "《" + name + "》\n作者: " + author + "\n价格: ¥" + price + "，页数: " + pages;
        }
    }

    // 新的数据列表：与 bookList 一一对应
    private List<Book> bookDataList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        //按钮初始化
        Button button1 = findViewById(R.id.second_layout_button_1);
        Button button2 = findViewById(R.id.second_layout_button_2);
        Button button3 = findViewById(R.id.create_database);

        Button btnAdd = findViewById(R.id.btn_add);
        Button btnUpdate = findViewById(R.id.btn_update);
        Button btnDelete = findViewById(R.id.btn_delete);
        Button btnQueryAll = findViewById(R.id.btn_query_all);
        //文本框初始化
        EditText nameEdit = findViewById(R.id.edit_name);
        EditText authorEdit = findViewById(R.id.edit_author);
        EditText priceEdit = findViewById(R.id.edit_price);
        EditText pagesEdit = findViewById(R.id.edit_pages);

        //listview部分
        ListView listView = findViewById(R.id.book_list_view);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bookList);
        listView.setAdapter(adapter);
        // 设置点击事件：点击 ListView 的一项自动填入 EditText
        listView.setOnItemClickListener((parent, view, position, id) -> {
            if (position >= bookDataList.size()) return;

            Book selectedBook = bookDataList.get(position);
            nameEdit.setText(selectedBook.name);
            authorEdit.setText(selectedBook.author);
            priceEdit.setText(String.valueOf(selectedBook.price));
            pagesEdit.setText(String.valueOf(selectedBook.pages));

            originalBookName = selectedBook.name; // 保存原始书名

            Toast.makeText(SecondActivity.this, "已选中《" + selectedBook.name + "》", Toast.LENGTH_SHORT).show();
        });


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

        //按钮4
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示跳转页面2 to 页面3
                //  使用 Toast 类创建一个短暂显示的消息提示，Toast.LENGTH_SHORT 的显示时长约为 2 秒。
                Toast.makeText(SecondActivity.this, "你使用显式Intent跳转到了页面3", Toast.LENGTH_SHORT).show();
                //  跳转（二选一）显式Intent和隐式Intent
                //使用显式Intent实现跳转
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

        //按钮5 数据库
        //数据库名为BookStore，版本为1,可以通过升级版本来更新数据库
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //按钮点击事件里调用getWritableDatabase()方法，当第一次点击会自动创建book表
                dbHelper.getWritableDatabase();
                Toast.makeText(SecondActivity.this, "已点击按钮，尝试创建数据库", Toast.LENGTH_SHORT).show();

                // 检查数据库文件是否真的存在，用Toast弹窗显示调试状态
                File dbFile = getDatabasePath("BookStore.db");
                if (dbFile.exists()) {
                    Toast.makeText(SecondActivity.this, "数据库已存在", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SecondActivity.this, "数据库未成功创建", Toast.LENGTH_SHORT).show();
                }


            }
        });





        // 添加
        btnAdd.setOnClickListener(v -> {
            String name = nameEdit.getText().toString();
            String author = authorEdit.getText().toString();
            String priceStr = priceEdit.getText().toString();
            String pagesStr = pagesEdit.getText().toString();

            if (name.isEmpty() || author.isEmpty() || priceStr.isEmpty() || pagesStr.isEmpty()) {
                Toast.makeText(this, "请填写完整信息", Toast.LENGTH_SHORT).show();
                return;
            }

            double price = Double.parseDouble(priceStr);
            int pages = Integer.parseInt(pagesStr);

            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("author", author);
            values.put("price", price);
            values.put("pages", pages);
            db.insert("Book", null, values);
            Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
            db.close();
        });

        // 更新（通过书名修改价格）
        btnUpdate.setOnClickListener(v -> {
            String name = nameEdit.getText().toString();
            String author = authorEdit.getText().toString();
            String priceStr = priceEdit.getText().toString();
            String pagesStr = pagesEdit.getText().toString();

            if (originalBookName == null) {
                Toast.makeText(this, "请先点击一项图书进行编辑", Toast.LENGTH_SHORT).show();
                return;
            }

            if (name.isEmpty() || author.isEmpty() || priceStr.isEmpty() || pagesStr.isEmpty()) {
                Toast.makeText(this, "请填写完整信息", Toast.LENGTH_SHORT).show();
                return;
            }

            double price = Double.parseDouble(priceStr);
            int pages = Integer.parseInt(pagesStr);

            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("author", author);
            values.put("price", price);
            values.put("pages", pages);

            int rows = db.update("Book", values, "name=?", new String[]{originalBookName});
            db.close();

            if (rows > 0) {
                Toast.makeText(this, "图书信息更新成功", Toast.LENGTH_SHORT).show();
                originalBookName = name; // 更新成功后同步更新“原始书名”
            } else {
                Toast.makeText(this, "未找到该书，更新失败", Toast.LENGTH_SHORT).show();
            }
        });

        // 删除
        btnDelete.setOnClickListener(v -> {
            String name = nameEdit.getText().toString();
            if (name.isEmpty()) {
                Toast.makeText(this, "请输入书名", Toast.LENGTH_SHORT).show();
                return;
            }

            SQLiteDatabase db = dbHelper.getWritableDatabase();
            int rows = db.delete("Book", "name=?", new String[]{name});
            Toast.makeText(this, rows > 0 ? "删除成功" : "未找到该书", Toast.LENGTH_SHORT).show();
            db.close();
        });

        // 查询

        btnQueryAll.setOnClickListener(v -> {
            bookList.clear();        // 给 ListView 显示的文本
            bookDataList.clear();    // 实际存储完整信息

            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = db.query("Book", null, null, null, null, null, null);

            if (cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                    String author = cursor.getString(cursor.getColumnIndexOrThrow("author"));
                    double price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"));
                    int pages = cursor.getInt(cursor.getColumnIndexOrThrow("pages"));

                    Book book = new Book(name, author, price, pages);
                    bookDataList.add(book);
                    bookList.add(book.toString()); // 显示在列表中的字符串
                } while (cursor.moveToNext());
            } else {
                bookList.add("暂无图书记录");
            }

            cursor.close();
            db.close();

            adapter.notifyDataSetChanged();
        });



    }
}