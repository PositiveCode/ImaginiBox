package com.geneus.imaginibox.ui;


import android.content.Context;
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                this.setBackgroundColor(getContext().getColor(R.color.faded_gray));
                this.setPaddingRelative(8, 8, 8, 8);

                Glide.with(getContext().getApplicationContext())
                        .load(DrawableUtils.randomizeDrawable(getContext()))
                        .into(this);

                break;
            }

        }
        return true;
    }
}
