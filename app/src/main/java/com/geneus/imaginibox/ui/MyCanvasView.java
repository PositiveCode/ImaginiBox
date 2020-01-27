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

        mPadding = 100;

        this.isTwoByTwo = isTwoByTwo;

        scaleDetector = new ScaleGestureDetector(context, new ScaleListener());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isTwoByTwo) {
            //top 2 rects
            drawRect(canvas, mPadding, mPadding, 800, 800, mPaint);
            drawRect(canvas, mPadding + 800, mPadding, 1600, 800, mPaint);

            //bottom 2 rects
            drawRect(canvas, mPadding, mPadding + 800, 800, 1600, mPaint);
            drawRect(canvas, mPadding + 800, mPadding + 800, 1600, 1600, mPaint);
        } else {
            //top 3 rects
            drawRect(canvas, mPadding, mPadding, 800, 800, mPaint);
            drawRect(canvas, mPadding + 800, mPadding, 1600, 800, mPaint);
            drawRect(canvas, mPadding + 1600, mPadding, 2400, 800, mPaint);

            //middle 3 rects
            drawRect(canvas, mPadding, mPadding + 800, 800, 1600, mPaint);
            drawRect(canvas, mPadding + 800, mPadding + 800, 1600, 1600, mPaint);
            drawRect(canvas, mPadding + 1600, mPadding + 800, 2400, 1600, mPaint);

            //bottom 3 rects
            drawRect(canvas, mPadding, mPadding + 1600, 800, 2400, mPaint);
            drawRect(canvas, mPadding + 800, mPadding + 1600, 1600, 2400, mPaint);
            drawRect(canvas, mPadding + 1600, mPadding + 1600, 2400, 2400, mPaint);

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
