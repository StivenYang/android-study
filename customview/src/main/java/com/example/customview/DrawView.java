package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {

    private float currentX = 40f;
    private float currentY = 50f;

    private Paint p = new Paint();


    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔的颜色
        p.setColor(Color.RED);
        //画一个小圆
        canvas.drawCircle(currentX, currentY, 15F, p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //重写触碰事件
        currentX = event.getX();
        currentY = event.getY();
        //通知当前组件重绘自己
        invalidate();
        //返回true表明该处理方法已经处理该事件
        return true;
    }
}
