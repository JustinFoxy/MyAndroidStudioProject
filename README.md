# AndroidStudio 大作业

## 设计需求

1. 作业内容：自选主题，独立完成应用开发，尽可能多、全面地展示本学期的学习内容，**必须可以完整运行**
2. 提交时间：第15周附近（六月上旬，时间未定）
3. 提交内容：实验报告 + 工程文件打包 + 录屏（可选，强烈推荐）

 *实验报告中包含：截图介绍所有实现的功能、非自己编写或从课程样例中获得的代码（包括代码来源）、课程中未涉及到的知识点*

4. 提交方式：标题为 姓名+学号， 发送至邮箱 [mad_sjqu@126.com](mailto:mad_sjqu@126.com)
5. 检查方式：视情况安排一对一腾讯会议进行答辩，或者QQ上询问
6. 分数计算：替代期末的上机考试，占总成绩40%



## 前端部分

### 第一个页面

##### res/layout/first_layout.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
    
    <Button
        android:id="@+id/first_layout_button_1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/first_layout_button_1" />

    <Button
        android:id="@+id/first_layout_button_2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/first_layout_button_2" />

    <Button
        android:id="@+id/first_layout_button_3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/first_layout_button_3"
        android:textAllCaps="false" />

    <Button
        android:id="@+id/first_layout_button_4"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/first_layout_button_4"
        android:textAllCaps="false" />
    <Button
        android:id="@+id/first_layout_button_5"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/first_layout_button_5" />

    <ImageView
        android:id="@+id/image_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/img1" />


</LinearLayout>
```

**代码解析：**

`android:id="@+id/btn1"`：为按钮设定一个唯一的标识符 btn1，借助这个 ID可以在 Java 代码里能够获取该按钮实例，进而对其进行操作。 

`android:layout_width="match_parent"`：此属性规定按钮的宽度会和父容器的宽度保持一致。 

`android:layout_height="wrap_content"`：该属性表明按钮的高度会依据其内容（也就是按钮上显示的文本）自动调整。

`android:text="@string/button_1"`：这里是引用了字符串资源 button_1，其作用是把这个字符串显示在按钮上。



##### res/values/strings.xml

```xml
<resources>
    <string name="app_name">Activity</string>
    <string name="label学号姓名">2411644邱志成 第一个页面</string>
    <string name="first_layout_button_1">跳转到第二个页面（显式）</string>
    <string name="first_layout_button_2">跳转到第二个页面（隐式）</string>
    <string name="first_layout_button_3">打开百度引擎（使用intent）</string>
    <string name="first_layout_button_4">打电话给自己（使用intent）</string>
    <string name="first_layout_button_5">切换图片</string>
    <string name="second_layout_button_1">跳转到第一个页面（显式）</string>
    <string name="second_layout_button_2">跳转到第三个页面（显式）</string>
    <string name="edit_text">请输入内容</string>
    <string name="show_input_button">显示输入内容（使用Toast）</string>
    <string name="dialog_button">点我跳出弹窗</string>
    <string name="third_layout_button1">跳转到第一个页面（显式）</string>
    <string name="third_layout_button2">跳转到第二个页面（显式）</string>
    <string name="instrument_name">乐器名</string>
    <string name="create_database">创建数据库</string>
</resources>
```

**在res中新建menu的资源库，并在资源库中新建main.xml**

##### res/menu/main.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">

    <item android:id="@+id/add_item"
        android:title="我是一个添加"/>
    <item android:id="@+id/remove_item"
        android:title="我是一个删除"/>
</menu>
```

### 第二个页面

##### second_layout.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".SecondActivity">

    <Button
        android:id="@+id/second_layout_button_1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/second_layout_button_1" />

    <Button
        android:id="@+id/second_layout_button_2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/second_layout_button_2" />

    <EditText
        android:id="@+id/edit_text"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/edit_text" />
    <Button
        android:id="@+id/show_input_button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/show_input_button"
        android:textAllCaps="false" />
    <Button
        android:id="@+id/dialog_button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/dialog_button"/>
    <Button
        android:id="@+id/create_database"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/create_database" />

</LinearLayout>
```

### 第三个页面

##### third_layout.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".ThirdActivity">

    <Button
        android:id="@+id/third_layout_button1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/third_layout_button1"/>

    <Button
        android:id="@+id/third_layout_button2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/third_layout_button2"/>

    <ListView
        android:id="@+id/list_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</LinearLayout>
```

##### Instruments_item.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="12dp">

<!--    图片-->
    <ImageView
        android:id="@+id/instrument_image"
        android:layout_width="90dp"
        android:layout_height="110dp"
        android:src="@drawable/ic_launcher_foreground"
        android:scaleType="centerCrop" />

    <TextView
        android:id="@+id/instrument_name"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_vertical"
        android:layout_marginStart="16dp"
        android:textSize="18sp"
        android:textColor="@color/black"
        android:text="@string/instrument_name" />
</LinearLayout>
```



## 后端部分

### FirstActivity.java

```java
package com.example.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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
                Toast.makeText(FirstActivity.this, "你切换到了第" + (imageIndex + 1) + "张图片", Toast.LENGTH_SHORT).show();
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
```

### SecondActivity.java

```java
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

import java.io.File;

public class SecondActivity extends AppCompatActivity {

    //初始化数据库
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        //按钮初始化
        Button button1 = findViewById(R.id.second_layout_button_1);
        Button button2 = findViewById(R.id.show_input_button);
        Button button3 = findViewById(R.id.dialog_button);
        Button button4 = findViewById(R.id.second_layout_button_2);
        Button button5 = findViewById(R.id.create_database);
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

        //按钮4
        button4.setOnClickListener(new View.OnClickListener() {
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
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        button5.setOnClickListener(new View.OnClickListener() {
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
    }
}
```

### ThirdActivity.java

```java
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
```

### Manifest文件配置

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.activity">

    <application
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.Activity">

        <!-- 给页面中添加label -->
        <activity
            android:name=".FirstActivity"
            android:exported="true"
            android:label="@string/label学号姓名">

            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>

        </activity>

        <activity
            android:name=".SecondActivity"
            android:exported="true"
            android:label="第二个页面">
            <intent-filter>
                <action android:name="com.example.activity.ACTION_START"/>
                <category android:name="android.intent.category.DEFAULT"/>
                <category android:name="com.example.activity.My_Category"/>
            </intent-filter>
        </activity>

        <activity
            android:name=".ThirdActivity"
            android:exported="true"
            android:label="第三个页面">
            <intent-filter>
                <action android:name="com.example.activity.THIRD_ACTION"/>
                <category android:name="android.intent.category.DEFAULT"/>
            </intent-filter>
        </activity>

    </application>

</manifest>
```

### Instruments.java

```java
package com.example.activity;

public class Instruments {
    private String name;
    private int imageId;
    public Instruments(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}

```

### InstrumentsAdapter.java

```java
package com.example.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class InstrumentsAdapter extends ArrayAdapter<Instruments> {
    private int resourceId;

    public InstrumentsAdapter(Context context, int textViewResourceId, List<Instruments> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Instruments instruments = getItem(position); // 获取当前项的实例

        View view;
        ViewHolder viewHolder;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.instrumentImage = view.findViewById(R.id.instrument_image);
            viewHolder.instrumentName = view.findViewById(R.id.instrument_name);
            view.setTag(viewHolder); // 缓存 viewHolder 对象
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        if (instruments != null) {
            viewHolder.instrumentImage.setImageResource(instruments.getImageId());
            viewHolder.instrumentName.setText(instruments.getName());
        }

        return view;
    }

    // 内部类用于优化性能（ViewHolder 模式）
    static class ViewHolder {
        ImageView instrumentImage;
        TextView instrumentName;
    }
}
```

### MyDatabaseHelper.java

```java
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

    //两个方法自己需要重写
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

```



## 结果截图展示





