# AndroidStudio 大作业

## 设计需求

1. 作业内容：自选主题，独立完成应用开发，尽可能多、全面地展示本学期的学习内容，**必须可以完整运行**
2. 提交时间：第15周附近（六月上旬，时间未定）
3. 提交内容：实验报告 + 工程文件打包 + 录屏（可选，强烈推荐）

 *实验报告中包含：截图介绍所有实现的功能、非自己编写或从课程样例中获得的代码（包括代码来源）、课程中未涉及到的知识点*

4. 提交方式：标题为 姓名+学号， 发送至邮箱 [mad_sjqu@126.com](mailto:mad_sjqu@126.com)
5. 检查方式：视情况安排一对一腾讯会议进行答辩，或者QQ上询问
6. 分数计算：替代期末的上机考试，占总成绩40%



## 项目介绍

本次安卓课程的项目是一个**基于 Java 的图书管理系统，主要实现了图书的增删改查功能**。项目采用 Android 原生开发，使用 SQLite 数据库进行数据持久化存储，界面使用了 ListView 实现图书信息的展示。

项目主要包括**三个 Activity**：**主页面负责跳转和按钮的实际使用**，**第二页面实现图书管理功能**。图书信息通过自定义 Book 类表示，包括书名、作者、价格、页数字段。用户通过输入框添加图书，点击列表项可以进行编辑或删除。**第三页面展示listview的功能**。

项目中使用了 SQLite 数据库，自定义 SQLiteOpenHelper 类来管理数据库创建和升级。数据表 Book 包含 id、书名、作者、价格、页数五个字段，id 为主键自增长。

在 UI 上我使用了 ListView 和 ArrayAdapter 来实现图书列表的更新。每次添加或修改数据后，ListView 会即时刷新数据，确保用户体验连贯。同时，我加入了 Toast 提示信息，提升交互感知。

### 常见的问题和解答

| **问题方向**   | **示例**                                | **回答**                                         |
| -------------- | :-------------------------------------- | ------------------------------------------------ |
| 数据库设计     | 你为什么选择用 SQLite？                 | SQLite 原生简单易控，对初学者更直观。            |
| 页面跳转       | Activity 是怎么跳转的？用了 Intent 吗？ | 使用 Intent 显式跳转，传递数据可用 putExtra()    |
| 列表更新逻辑   | ListView 添加数据后怎么更新？           | 数据源变更后调用 notifyDataSetChanged() 刷新列表 |
| 数据持久化机制 | 你如何实现添加数据后保存？              | 调用 SQLite 的 insert 操作，保存在数据库中       |

## GitHub连接：

https://github.com/JustinFoxy/MyAndroidStudioProject

本次大作业我将代码和readme文档上传到了我的仓库，便于查看自己的进度和上传自己的作品。



## 前端部分

### 第一个页面

##### res/layout/first_layout.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<!-- 页面布局使用垂直方向排列的线性布局 -->
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"    <!-- 宽度填满整个屏幕 -->
    android:layout_height="match_parent"   <!-- 高度填满整个屏幕 -->
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"         <!-- 子元素垂直排列 -->
    tools:context=".FirstActivity">        <!-- 关联的 Activity 类 -->

<!-- 第一个按钮：跳转到页面二（显示） -->
    <Button
        android:id="@+id/first_layout_button_1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/first_layout_button_1" />
<!-- 第二个按钮：跳转到页面二（隐式） -->
    <Button
        android:id="@+id/first_layout_button_2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/first_layout_button_2" />

    <Button
        android:id="@+id/first_layout_button_6"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="跳转到第三个页面（隐式）"/>
    <Button
        android:id="@+id/first_layout_button_3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/first_layout_button_3"
        android:textAllCaps="false" /> <!-- 不将文本全部转换为大写 -->
    <Button
        android:id="@+id/first_layout_button_4"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/first_layout_button_4"
        android:textAllCaps="false" />
    <Button
        android:id="@+id/dialog_button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/dialog_button"/>

<!-- 输入框：供用户输入文本 -->
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

`android:layout_width="match_parent"`：按钮的宽度会和父容器的宽度保持一致。 

`android:layout_height="wrap_content"`：按钮的高度会依据其内容（也就是按钮上显示的文本）自动调整。

`android:text="@string/button_1"`：引用了字符串资源 button_1，其作用是把这个字符串显示在按钮上。

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
    <string name="update_data">更新数据</string>
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

### 第二个页面：图书管理页面

##### second_layout.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<!-- 垂直线性布局，用于图书信息录入与管理操作 -->
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"        <!-- 宽度填满屏幕 -->
    android:layout_height="match_parent"       <!-- 高度填满屏幕 -->
    android:orientation="vertical"             <!-- 子控件垂直排列 -->
    tools:context=".SecondActivity">           <!-- 指定绑定的 Activity -->

    <!-- 返回主页面 -->
    <Button
        android:id="@+id/second_layout_button_1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/second_layout_button_1" />

    <!-- 跳转到第三页面（若有） -->
    <Button
        android:id="@+id/second_layout_button_2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/second_layout_button_2" />

    <!-- 创建数据库按钮 -->
    <Button
        android:id="@+id/create_database"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/create_database" />

    <!-- 以下是图书信息录入区域 -->
    
    <!-- 输入书名 -->
    <EditText
        android:id="@+id/edit_name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="书名" />

    <!-- 输入作者 -->
    <EditText
        android:id="@+id/edit_author"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="作者" />

    <!-- 输入价格（小数） -->
    <EditText
        android:id="@+id/edit_price"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="价格"
        android:inputType="numberDecimal" />

    <!-- 输入页数（整数） -->
    <EditText
        android:id="@+id/edit_pages"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="页数"
        android:inputType="number" />

    <!-- 图书操作按钮区域 -->

    <!-- 添加图书记录 -->
    <Button
        android:id="@+id/btn_add"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="添加图书" />

    <!-- 修改图书记录 -->
    <Button
        android:id="@+id/btn_update"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="更改图书内容" />

    <!-- 删除图书记录 -->
    <Button
        android:id="@+id/btn_delete"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="删除图书" />

    <!-- 查询所有图书记录 -->
    <Button
        android:id="@+id/btn_query_all"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="查询所有图书" />

    <!-- 图书列表展示 -->
    <ListView
        android:id="@+id/book_list_view"
        android:layout_width="match_parent"
        android:layout_height="300dp" />
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

<!--    图片旁边的文本内容
    字离图片的距离 layout_marginStart
    文本与图片居中 layout_gravity="center_vertical"

-->
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

### 第一个页面

#### FirstActivity.java

```java
package com.example.activity;

import ...

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
```

### 第二个页面

#### SecondActivity.java

```java
package com.example.activity;

import ....

public class SecondActivity extends AppCompatActivity {

    //初始化数据库
    private MyDatabaseHelper dbHelper;// 数据库辅助类，用于数据库操作
    private ArrayAdapter<String> adapter;// ListView 的适配器，用于展示简洁文本信息
    private List<String> bookList = new ArrayList<>();// 字符串列表，用于展示图书内容摘要
    private String originalBookName = null;// 记录当前选中的原始书名，用于更新操作时定位数据

    // 定义一个图书类，用于封装图书完整信息
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

    // 储存完整图书信息的列表：与 bookList 一一对应
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

        //设置listview与适配器，并绑定点击事件用于选中图书进行更新
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

        //跳转回页面一
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

        //跳转到页面三
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示跳转页面2 to 页面3
                //  使用 Toast 类创建一个短暂显示的消息提示，Toast.LENGTH_SHORT 的显示时长约为 2 秒。
                Toast.makeText(SecondActivity.this, "你使用显式Intent跳转到了页面3", Toast.LENGTH_SHORT).show();
                //使用显式Intent实现跳转
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

        //数据库
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
      
        // 添加图书
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

        // 修改图书信息（通过原书名定位）
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

        // 删除图书
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

        // 查询所有图书
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
```

### 第三个页面

#### ThirdActivity.java

```java
package com.example.activity;

import ...
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
```

### Manifest文件配置

```xml
<?xml version="1.0" encoding="utf-8"?>
<!-- AndroidManifest 是整个应用的核心配置文件 -->
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.activity">

    <!-- 应用的整体属性配置 -->
    <application
        android:icon="@mipmap/ic_launcher"              <!-- 应用图标 -->
        android:label="@string/app_name"                <!-- 应用名称 -->
        android:roundIcon="@mipmap/ic_launcher_round"   <!-- 圆角图标（用于部分设备） -->
        android:supportsRtl="true"                      <!-- 支持从右到左布局（如阿拉伯语） -->
        android:theme="@style/Theme.Activity">          <!-- 应用主题 -->

        <!-- 页面一：FirstActivity，设置为应用的启动页 -->
        <activity
            android:name=".FirstActivity"
            android:exported="true"
            android:label="@string/label学号姓名">       <!-- 页面标题，会显示在应用顶部 -->

            <!-- 配置启动入口（主入口 + 启动器图标） -->
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

        <!-- 页面二：SecondActivity，支持通过隐式 Intent 调用 -->
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

        <!-- 页面三：ThirdActivity，支持通过自定义 Action 调用 -->
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

### 乐器

#### Instruments.java

```java
package com.example.activity;
//Instruments 类用于封装乐器对象，包含乐器的名称和图片资源 ID。
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

#### InstrumentsAdapter.java

```java
package com.example.activity;

import ....

  //InstrumentsAdapter 是自定义适配器，用于将 Instruments 对象绑定到 ListView 的每个条目中。
  //使用 ViewHolder 模式提高性能。
public class InstrumentsAdapter extends ArrayAdapter<Instruments> {
    private int resourceId; // 每个列表项使用的布局资源 ID
  
 /*  	构造方法
      @param context 上下文对象
      @param textViewResourceId 列表项布局资源 ID
      @param objects 乐器对象列表				*/
    public InstrumentsAdapter(Context context, int textViewResourceId, List<Instruments> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

  // 重写 getView 方法，为 ListView 的每一项加载布局并绑定数据
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // 获取当前项的乐器对象
        Instruments instruments = getItem(position);

        View view;
        ViewHolder viewHolder;

        // 判断是否可复用已有的视图（提高性能）
        if (convertView == null) {
            // 若不可复用，则手动加载新的布局，并创建 ViewHolder 来缓存子控件引用
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.instrumentImage = view.findViewById(R.id.instrument_image);
            viewHolder.instrumentName = view.findViewById(R.id.instrument_name);
            view.setTag(viewHolder); // 将 viewHolder 缓存到 view 中
        } else {
            // 若已有可复用的视图，则直接读取缓存的 ViewHolder
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        // 将乐器对象的数据设置到对应控件上
        if (instruments != null) {
            viewHolder.instrumentImage.setImageResource(instruments.getImageId());
            viewHolder.instrumentName.setText(instruments.getName());
        }
        return view;
    }

    // 静态内部类：用于缓存子控件，避免频繁 findViewById 调用，提高列表滚动性能
    static class ViewHolder {
        ImageView instrumentImage;
        TextView instrumentName;
    }
}
```

### 数据库部分

#### MyDatabaseHelper.java

```java
package com.example.activity;

import ...
//	MyDatabaseHelper 是一个用于创建和管理 SQLite 数据库的辅助类。
//	包含两个数据表：Book 和 Category，支持数据库创建和版本升级。

public class MyDatabaseHelper extends SQLiteOpenHelper {
    //SQL 语句：创建 Book 表【包含id（主键，自增长）、作者、价格、页数、书名】
  	//integer整型，real浮点型，text文本类型
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

    //四个参数【context、数据库名name、返回自定义Cursor，默认为null、当前数据库版本号】
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
```





