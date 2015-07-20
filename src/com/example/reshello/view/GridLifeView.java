package com.example.reshello.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

import com.example.reshello.R;

/**
 * Created by wangqianqian on 15/4/27.
 */
public class GridLifeView extends View {

    private int model;

    private int month;

    private int cellSize;

    private int age;

    private int beginMonth;

    private int color;

    private int width;

    public static int LINE_COLOR = Color.argb(255, 154, 154, 154);

    public GridLifeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        //获取自定义View的属性资源
        TypedArray a = context.obtainStyledAttributes(attributeSet, R.styleable.GridLifeView);
        this.model = a.getInteger(R.styleable.GridLifeView_model, 0);
        this.age = a.getInteger(R.styleable.GridLifeView_age, 0);
        this.month = a.getInteger(R.styleable.GridLifeView_month, 0);
        this.beginMonth = a.getInteger(R.styleable.GridLifeView_beginMonth, 0);
        this.color = a.getColor(R.styleable.GridLifeView_color, Color.argb(255, 154, 154, 154));
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        this.cellSize = (width - 120) / 30;
        this.width = cellSize * 30;
    }

    @Override
    protected void onDraw(Canvas cv) {
        super.onDraw(cv);
        Paint cellPaint_1 = new Paint();
        cellPaint_1.setColor(color);  //事件色彩
        switch (model) {
            case 0:
                int totalMonth = age * 12;
                int mod = totalMonth % 30;
                int beishu = totalMonth / 30;
                cv.drawRect(0, 0, width, cellSize * beishu, cellPaint_1);
                cv.drawRect(0, cellSize * beishu, mod * cellSize, (cellSize * (beishu + 1)), cellPaint_1);
                break;
            case 1:
                int startMonth = age * 12;
                for (int i = startMonth; i < startMonth + month; i++) {
                    cv.drawRect((cellSize * (i % 30)), (cellSize * (i / 30)), (cellSize * (i % 30 + 1)), (cellSize * (i / 30 + 1)), (cellPaint_1));
                }
                break;
            case 2:
                for (int i = this.beginMonth; i < this.beginMonth + month; i++) {
                    cv.drawRect((cellSize * (i % 30)), (cellSize * (i / 30)), (cellSize * (i % 30 + 1)), (cellSize * (i / 30 + 1)), (cellPaint_1));
                }
                break;

        }


        Paint background = new Paint();
        background.setColor(getResources().getColor(R.color.black));
        background.setAntiAlias(true);//设置画笔去锯齿
        background.setColor(LINE_COLOR);
        for (int i = 0; i < 30; i++) {
            cv.drawLine(cellSize * i, 0, cellSize * i, width, background);
        }
        for (int i = 0; i < 30; i++) {
            cv.drawLine(0, cellSize * i, width, cellSize * i, background);
        }
    }
}
