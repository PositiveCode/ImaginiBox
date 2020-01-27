package com.geneus.imaginibox.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class CanvasView extends View {
    Paint mPaint;
    int mPadding;
    private Canvas canvas;

    public CanvasView(Context context, Canvas canvas) {
        super(context);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);

        mPadding = 800;

        this.canvas = canvas;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.canvas.drawRect(mPadding, mPadding, 1600, 1600, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = 800;
        int height = 800 + 50; // Since 3000 is bottom of last Rect to be drawn added and 50 for padding.
        setMeasuredDimension(width, height);
    }

    public static float pxFromDp(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
}
