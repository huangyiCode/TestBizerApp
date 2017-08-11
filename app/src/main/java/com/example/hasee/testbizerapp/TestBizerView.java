package com.example.hasee.testbizerapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hasee on 2017/8/11.
 */

public class TestBizerView extends View {

    /**
     * 初始化画笔
     */
    Paint mPaint;

    /**
     * 曲线起始点的坐标
     */
    private static int START_X_POINT=0;
    private static int START_Y_POINT=200;

    /**
     * 波长度
     */
    private static int WAVE_LENGTH=200;

    /**
     *波峰高度
     */
    private static int WAVE_HEIGHT=50;




    public TestBizerView(Context context) {
        this(context,null);
    }

    public TestBizerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TestBizerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化画笔
     */
    public void init(){
        mPaint=new Paint();
        //1.设置画笔颜色
        mPaint.setColor(Color.RED);
        //2.设置抗锯齿
        mPaint.setAntiAlias(true);
        //3.设置画笔风格
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //1.初始化一个Path路径
        Path p=new Path();
        //2.设置路径的起始点(Bizer的起始点)
        p.moveTo(START_X_POINT,START_Y_POINT);
        //3.绘制一个波长的贝塞尔曲线
//        //控制点坐标:WAVE_LENGTH/4,START_Y_POINT-WAVE_HEIGHT
//        //结束点坐标:WAVE_LENGTH/2,START_Y_POINT
//        p.quadTo(WAVE_LENGTH/4,START_Y_POINT-WAVE_HEIGHT,WAVE_LENGTH/2,START_Y_POINT);
//        //以上一次的结束点为起始点
//        p.quadTo(WAVE_LENGTH*3/4,START_Y_POINT+WAVE_HEIGHT,WAVE_LENGTH,START_Y_POINT);

        for (int i = 0; i <20 ; i++) {
            p.quadTo(WAVE_LENGTH*(i*2+1)/4,i%2==0?START_Y_POINT-WAVE_HEIGHT:START_Y_POINT+WAVE_HEIGHT,WAVE_LENGTH*(i+1)/2,START_Y_POINT);
        }


        //4.绘制路径
        canvas.drawPath(p,mPaint);



    }
}
