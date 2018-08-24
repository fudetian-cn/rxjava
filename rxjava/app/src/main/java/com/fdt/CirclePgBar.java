package com.fdt;

/**
 * Created by fudetian on 2018/7/10.
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xianfengzhang on 2017/12/22.
 */

public class CirclePgBar extends View {
    private Paint mBackPaint;
    private Paint mFrontPaint;
    private Paint mTextPaint;
    private float mStrokeWidth = 50;
    private float mHalfStrokeWidth = mStrokeWidth / 2;
    private float mRadius = 100;
    private RectF mRect;
    private int mProgress = 0;
    //目标值，想改多少就改多少
    private int mTargetProgress = 0;
    private int mMax = 100;
    private int mWidth;
    private int mHeight;

    //    构造方法
    public CirclePgBar(Context context) {
        super(context);
        init();
    }

    public CirclePgBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CirclePgBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mBackPaint = new Paint();
        mBackPaint.setColor(Color.WHITE);//设置画笔颜色
        mBackPaint.setAntiAlias(true);//设置画笔锯齿效果
        mBackPaint.setStyle(Paint.Style.STROKE);//设置画笔风格（空心|实心）
        mBackPaint.setStrokeWidth(mStrokeWidth);//设置空心边框的宽度

        mFrontPaint = new Paint();
        mFrontPaint.setColor(Color.GREEN);
        mFrontPaint.setAntiAlias(true);
        mFrontPaint.setStyle(Paint.Style.STROKE);
        mFrontPaint.setStrokeWidth(mStrokeWidth);


        mTextPaint = new Paint();
        mTextPaint.setColor(Color.GREEN);//设置字体颜色
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(80);//设置字体大小
        mTextPaint.setTextAlign(Paint.Align.CENTER);//设置字体对齐方式

    }

    //onMeasure（测量控件大小的方法） 重写onMeasure方法
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getRealSize(widthMeasureSpec);
        mHeight = getRealSize(heightMeasureSpec);
        setMeasuredDimension(mWidth, mHeight);//保存测量的大小
    }

    //onDraw绘制View自身的内容 重写onDraw方法
    @Override
    protected void onDraw(Canvas canvas) {
        initRect();
        float angle = mProgress / (float) mMax * 360;
        canvas.drawCircle(mWidth / 2, mHeight / 2, mRadius, mBackPaint);
        canvas.drawArc(mRect, -90, angle, false, mFrontPaint);
        canvas.drawText(mProgress + "%", mWidth / 2 + mHalfStrokeWidth, mHeight / 2 + mHalfStrokeWidth, mTextPaint);
        if (mProgress < mTargetProgress) {
            mProgress += 1;
            invalidate();
        }
    }

    public void setTargetProgress(int targetProgress) {
        mTargetProgress = targetProgress;
        invalidate();
    }

    public int getRealSize(int measureSpec) {
        int result = 1;
        int mode = MeasureSpec.getMode(measureSpec);//从提供的测量规范中获取模式
        int size = MeasureSpec.getSize(measureSpec);//从提供的测量规范中获取尺寸
//MeasureSpec其实就是尺寸和模式通过各种位运算计算出的一个整型值，它提供了三种模式，还有三个方法（合成约束、分离模式、分离尺寸）
//UNSPECIFIED(未指定)：父控件没有对子控件施加任何约束，子控件可以得到任意想要的大小！
//EXACTLY(完全)：父控件给子控件决定了确切大小，子控件将被限定在给定的边界里而忽略它本身大小。
//AT_MOST(至多)：子控件至多达到指定大小的值。
        if (mode == MeasureSpec.AT_MOST || mode == MeasureSpec.UNSPECIFIED) {
            result = (int) (mRadius * 2 + mStrokeWidth);
        } else {
            result = size;
        }

        return result;
    }

    private void initRect() {
        if (mRect == null) {
            mRect = new RectF();
            int viewSize = (int) (mRadius * 2);
            int left = (mWidth - viewSize) / 2;
            int top = (mHeight - viewSize) / 2;
            int right = left + viewSize;
            int bottom = top + viewSize;
            mRect.set(left, top, right, bottom);
        }
    }
}
