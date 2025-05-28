package com.example.activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    //创建bookstore的数据库，在库中新建一个数据表Book【有id（主键，自增长）、作者、价格、页数、书名】integer整型，real浮点型，text文本类型
    public static final String CREATE_BOOK = "create table Book("
            + "id integer primary key autoincrement,"
            + "author text,"
            + "price real,"
            + "pages integer,"
            + "name text)";

    //创建bookstore的数据库，在库中新建一个数据表Category【有id（主键，自增长）、category_name文本类型，用来存储分类的名称、category_code整数类型，用来存储分类的编码
    public static final String CREATE_CATEGORY = "create table Category("
            + "id integer primary key autoincrement,"
            + "category_name text,"
            + "category_code integer)";


    private Context mContext;

    //四个参数【Context、数据库名、返回自定义Cursor，默认为null、当前数据库版本号】
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    //两个方法onCreate、onUpgrade自己需要重写
    @Override
    public void onCreate(SQLiteDatabase db) {
        //调用SQLiteDatabase中的execSQL的方法执行建表语句，Toast弹窗来显示创建成功
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        Toast.makeText(mContext, "数据库创建成功", Toast.LENGTH_SHORT).show();
    }

    //数据库升级
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);
    }
}
