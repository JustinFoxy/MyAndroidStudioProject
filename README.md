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
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

<!--    创建按钮btn1-->
    <Button
        android:id="@+id/btn1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/button_1" />

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
    <string name="button_1">Button 1</string>
    <string name="label学号姓名">2411644邱志成</string>
    <string name="button_2">Button 2</string>
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

##### activity_second.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SecondActivity">

    <Button
        android:id="@+id/btn2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/button_2"/>

</LinearLayout>
```



## 后端部分

##### java/com./FirstActivity.java

```java
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

    //	菜单栏menu部分
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

##### SecondActivity.java

```java
package com.example.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
```





## Manifest文件配置

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
            android:exported="false"
            android:label="第二个页面">
        </activity>

    </application>

</manifest>
```



## 结果截图展示

![Image](https://github.com/user-attachments/assets/179326e8-3545-4f74-83e6-9ca6d10a4426)
![Image](https://github.com/user-attachments/assets/439ef728-bf48-46b4-9edf-b744a992e783)
![Image](https://github.com/user-attachments/assets/31b612d5-e7fe-4609-b336-3df6747c6830)
![Image](https://github.com/user-attachments/assets/611b162a-ce9e-4c97-ac0c-fe1a1024c790)
![Image](https://github.com/user-attachments/assets/51020269-bcba-4b85-955c-b2e23ed58076)

![Image](https://github.com/user-attachments/assets/ee7979bc-fdb0-4527-a40b-673f15c91aa2)

