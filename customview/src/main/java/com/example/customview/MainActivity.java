package com.example.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取布局文件中的linearLayout容器
        LinearLayout root= findViewById(R.id.root);
        //创建DrawView组件
        DrawView drawView = new DrawView(this);
        //设置自定义组件的高度、宽度
        drawView.setMinimumWidth(300);
        drawView.setMinimumHeight(500);
        //新增View
        root.addView(drawView);
    }
}