package com.geneus.imaginibox.deprecated.viewComponents.GPUImageView;


import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.geneus.imaginibox.R;
import com.geneus.imaginibox.async.SetImageAsync;

import jp.co.cyberagent.android.gpuimage.GPUImageView;

public class TappableGPUImgView extends GPUImageView {

    public TappableGPUImgView(Context context) {
        super(context);

        setBackground(getContext().getDrawable(R.drawable.bg_square_frame_black));
        setBackgroundColor(Color.WHITE);
    }

    public TappableGPUImgView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private int tapCount = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                new SetImageAsync(this, getContext(), tapCount).execute("");
                tapCount++;

                if(tapCount > 4){
                    tapCount = 0;
                }

                break;
            }

        }
        return true;
    }
}
