package com.geneus.imaginibox.ui;


import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.geneus.imaginibox.R;

public class SquareImgView extends AppCompatImageView {
    public SquareImgView(Context context) {
        super(context);
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

                if(tapCount == 0){
                    Glide.with(getContext().getApplicationContext())
                            .load(getContext().getDrawable(R.drawable.ic_china))
                            .into(this);
                    tapCount++;
                }else if(tapCount == 1){
                    Glide.with(getContext().getApplicationContext())
                            .load(getContext().getDrawable(R.drawable.ic_usa))
                            .into(this);
                    tapCount++;
                }else if(tapCount == 2){
                    Glide.with(getContext().getApplicationContext())
                            .load(getContext().getDrawable(R.drawable.ic_malaysia))
                            .into(this);
                    tapCount++;
                }else if(tapCount == 3){
                    Glide.with(getContext().getApplicationContext())
                            .load(getContext().getDrawable(R.drawable.ic_japan))
                            .into(this);
                    tapCount = 0;
                }

                Toast.makeText(getContext(), "tapped..", Toast.LENGTH_SHORT).show();
                break;
            }

        }
        return true;
    }
}
