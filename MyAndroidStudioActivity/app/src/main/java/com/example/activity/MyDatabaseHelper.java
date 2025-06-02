package com.example.activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

//	MyDatabaseHelper 是一个用于创建和管理 SQLite 数据库的辅助类。
//	包含两个数据表：Book 和 Category，支持数据库创建和版本升级。
public class MyDatabaseHelper extends SQLiteOpenHelper {
    ///SQL 语句：创建 Book 表【包含id（主键，自增长）、作者、价格、页数、书名】
    ///integer整型，real浮点型，text文本类型
    public static final String CREATE_BOOK = "create table Book("
            + "id integer primary key autoincrement,"
            + "author text,"
            + "price real,"
            + "pages integer,"
            + "name text)";

    /// SQL 语句：创建 Category 表【包含id（主键，自增长）、category_name文本类型，用来存储分类的名称、category_code整数类型，用来存储分类的编码
    public static final String CREATE_CATEGORY = "create table Category("
            + "id integer primary key autoincrement,"
            + "category_name text,"
            + "category_code integer)";

    // 用于在创建数据库时显示 Toast 提示
    private Context mContext;

  /*
      构造方法：初始化数据库帮助类
      @param context 上下文对象
      @param name 数据库名称
      @param factory CursorFactory（通常为 null）
      @param version 数据库版本号
   */

    // 四个参数【context、数据库名name、返回自定义Cursor，默认为null、当前数据库版本号】
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    //两个方法onCreate、onUpgrade自己需要重写
    //第一次创建数据库时调用onCreate方法，执行建表语句
    @Override
    public void onCreate(SQLiteDatabase db) {
        //调用SQLiteDatabase中的execSQL的方法执行建表语句，Toast弹窗来显示创建成功
        db.execSQL(CREATE_BOOK);	// 创建 Book 表
        db.execSQL(CREATE_CATEGORY);	// 创建 Category 表
        Toast.makeText(mContext, "数据库创建成功", Toast.LENGTH_SHORT).show();
    }

    //数据库升级：数据库版本升级时调用此方法，可根据需要修改表结构
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Book");       // 删除旧的 Book 表
        db.execSQL("drop table if exists Category");   // 删除旧的 Category 表
        onCreate(db);                                   // 重新创建表结构
    }
}