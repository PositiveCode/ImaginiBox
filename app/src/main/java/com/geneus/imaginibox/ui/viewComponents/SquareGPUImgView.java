package com.geneus.imaginibox.ui.viewComponents;


import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.geneus.imaginibox.R;
import com.geneus.imaginibox.async.SetImageAsync;

import jp.co.cyberagent.android.gpuimage.GPUImageView;

public class SquareGPUImgView extends GPUImageView {

    public SquareGPUImgView(Context context) {
        super(context);

        setBackground(getContext().getDrawable(R.drawable.bg_square_frame_black));
        setBackgroundColor(Color.WHITE);
    }

    public SquareGPUImgView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                new SetImageAsync(this, getContext()).execute("");
                break;
            }

        }
        return true;
    }
}
