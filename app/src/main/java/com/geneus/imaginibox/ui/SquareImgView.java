package com.geneus.imaginibox.ui;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.geneus.imaginibox.R;

public class SquareImgView extends AppCompatImageView {

    public SquareImgView(Context context) {
        super(context);

        setBackground(getContext().getDrawable(R.drawable.bg_square_frame_black));
    }

    public SquareImgView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImgView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /*
     * 0 = china
     * 1 = usa
     * 2 = malaysia
     * 3 = japan
     * */
    int tapCount = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                this.setBackgroundColor(getContext().getColor(R.color.faded_gray));
                this.setPaddingRelative(8, 8, 8, 8);

                Drawable drawable = getContext().getDrawable(R.drawable.ic_china);

                if(tapCount == 0){
                    drawable = getContext().getDrawable(R.drawable.ic_china);
                }else if(tapCount == 1){
                    drawable = getContext().getDrawable(R.drawable.ic_usa);
                }else if(tapCount == 2){
                    drawable = getContext().getDrawable(R.drawable.ic_malaysia);
                }else if(tapCount == 3){
                    drawable = getContext().getDrawable(R.drawable.ic_japan);
                    tapCount = 0;
                }

                Glide.with(getContext().getApplicationContext())
                        .load(drawable)
                        .into(this);

                tapCount++;

                break;
            }

        }
        return true;
    }
}
