package com.geneus.imaginibox.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

public class MyCanvasView extends View {
    private Paint mPaint;
    private int mPadding;

    //coordinates to shift the view by
    private float shiftX = 0f;
    private float shiftY = 0f;

    private boolean isTwoByTwo = true;

    private ScaleGestureDetector scaleDetector;
    private float scaleFactor = 1.f;

    public MyCanvasView(Context context, boolean isTwoByTwo) {
        super(context);

        //canvas defaults
        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);

        mPadding = 50;

        this.isTwoByTwo = isTwoByTwo;

        scaleDetector = new ScaleGestureDetector(context, new ScaleListener());
    }

    private int mDimension = 350;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isTwoByTwo) {
            //top 2 rects
            drawRect(canvas, mPadding, mPadding, mDimension, mDimension, mPaint);
            drawRect(canvas, mPadding + mDimension, mPadding, mDimension *2, mDimension, mPaint);

            //bottom 2 rects
            drawRect(canvas, mPadding, mPadding + mDimension, mDimension, mDimension*2, mPaint);
            drawRect(canvas, mPadding + mDimension, mPadding + mDimension, mDimension*2, mDimension*2, mPaint);
        } else {
            //top 3 rects
            drawRect(canvas, mPadding, mPadding, mDimension, mDimension, mPaint);
            drawRect(canvas, mPadding + mDimension, mPadding, mDimension*2, mDimension, mPaint);
            drawRect(canvas, mPadding + mDimension*2, mPadding, mDimension*3, mDimension, mPaint);

            //middle 3 rects
            drawRect(canvas, mPadding, mPadding + mDimension, mDimension, mDimension*2, mPaint);
            drawRect(canvas, mPadding + mDimension, mPadding + mDimension, mDimension*2, mDimension*2, mPaint);
            drawRect(canvas, mPadding + mDimension*2, mPadding + mDimension, mDimension*3, mDimension*2, mPaint);

            //bottom 3 rects
            drawRect(canvas, mPadding, mPadding + mDimension*2, mDimension, mDimension*3, mPaint);
            drawRect(canvas, mPadding + mDimension, mPadding + mDimension*2, mDimension*2, mDimension*3, mPaint);
            drawRect(canvas, mPadding + mDimension*2, mPadding + mDimension*2, mDimension*3, mDimension*3, mPaint);

        }
        canvas.scale(scaleFactor, scaleFactor);

    }

    final public void drawRect(Canvas c, float left, float top, float right, float bottom, Paint paint) {
        c.drawRect((left + shiftX) * scaleFactor,
                (top + shiftY) * scaleFactor,
                (right + shiftX) * scaleFactor,
                (bottom + shiftY) * scaleFactor,
                paint);
    }

    public boolean onTouchEvent(MotionEvent event) {
        scaleDetector.onTouchEvent(event);
        return true;
    }

    private class ScaleListener extends
            ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scaleFactor *= detector.getScaleFactor();
            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 10.0f));
            invalidate();
            return true;
        }
    }

    public void setTwoByTwo(boolean twoByTwo) {
        isTwoByTwo = twoByTwo;
        invalidate();
    }
}
