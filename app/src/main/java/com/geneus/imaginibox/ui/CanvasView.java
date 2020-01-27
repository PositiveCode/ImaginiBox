package com.geneus.imaginibox.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class CanvasView extends View {
    Paint mPaint;
    int mPadding;

    //coordinates to shift the view by
    public float shiftX = 0f;
    public float shiftY = 0f;

    //used in the dragging code
    public float lastX = -1f;
    public float lastY = -1f;

    public boolean isTwoByTwo = true;

    public CanvasView(Context context, boolean isTwoByTwo) {
        super(context);

        //canvas defaults
        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);

        mPadding = 100;

        this.isTwoByTwo = isTwoByTwo;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(isTwoByTwo){
            //top 2 rects
            drawRect(canvas, mPadding, mPadding, 800, 800, mPaint);
            drawRect(canvas, mPadding + 800, mPadding, 1600, 800, mPaint);

            //bottom 2 rects
            drawRect(canvas, mPadding, mPadding + 800, 800, 1600, mPaint);
            drawRect(canvas, mPadding + 800, mPadding + 800, 1600, 1600, mPaint);
        }else{
            //top 3 rects
            drawRect(canvas, mPadding, mPadding, 800, 800, mPaint);
            drawRect(canvas, mPadding + 800, mPadding, 1600, 800, mPaint);
            drawRect(canvas, mPadding + 1600, mPadding, 2400, 800, mPaint);

            //bottom 3 rects
            drawRect(canvas, mPadding, mPadding + 800, 800, 1600, mPaint);
            drawRect(canvas, mPadding + 800, mPadding + 800, 1600, 1600, mPaint);
            drawRect(canvas, mPadding + 1600, mPadding + 800, 2400, 2400, mPaint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    final public void drawRect(Canvas c, float left, float top, float right, float bottom, Paint paint) {
        c.drawRect(left + shiftX, top + shiftY, right + shiftX, bottom + shiftY, paint);
    }

    public boolean onTouchEvent(MotionEvent event) {
        /*touch event listener which allows scrolling for canvas. */
        int eventaction = event.getAction();
        float x = event.getX();
        float y = event.getY();
        switch (eventaction) {
            case MotionEvent.ACTION_MOVE:
                if (lastX == -1) {
                    lastX = x;
                    lastY = y;
                }//initializing X, Y movement
                else {//moving by the delta
                    if (Math.abs(x - lastX) > 1 || Math.abs(y - lastY) > 1) {//this prevents jittery movement I experienced
                        shiftX += (x - lastX);//moves the shifting variables
                        shiftY += (y - lastY);//in the direction of the finger movement
                        lastX = x;//used to calculate the movement delta
                        lastY = y;
                        invalidate();//DON'T FORGET TO CALL THIS! this redraws the view
                    }
                }
                break;
        }
        return true;
    }
}
