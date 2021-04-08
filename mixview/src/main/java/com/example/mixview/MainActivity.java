package com.example.mixview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int[] images = new int[]{R.drawable.qiaoyunlong, R.drawable.liuhaiyan};
    private int currentImg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取LinearLayout布局容器
        LinearLayout main = findViewById(R.id.root);
        //创建imageView组件
        ImageView image = new ImageView(this);
        //讲imageView组件添加到LinearLayout布局容器中
        main.addView(image);
        //初始化时显示第一张图片
        image.setImageResource(images[0]);
        //改变ImageView里显示的图片
        image.setOnClickListener(view -> {
            image.setImageResource(images[++currentImg % images.length]);
        });
    }
}