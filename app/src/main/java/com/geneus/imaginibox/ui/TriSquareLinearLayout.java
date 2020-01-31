package com.geneus.imaginibox.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.geneus.imaginibox.R;

public class TriSquareLinearLayout extends LinearLayout {

    ImageView imgView1;
    ImageView imgView2;
    ImageView imgView3;

    public TriSquareLinearLayout(Context context) {
        super(context);
        setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(300, 300);
        params.setMargins(50, 50, 0, 50);

        imgView1 = new SquareImgView(context);
        imgView2 = new SquareImgView(context);
        imgView3 = new SquareImgView(context);

        imgView1.setBackgroundColor(context.getResources().getColor(R.color.colorPrimaryDark));
        imgView2.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        imgView3.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));

        addView(imgView1, params);
        addView(imgView2, params);
        addView(imgView3, params);
    }

    public TriSquareLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TriSquareLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TriSquareLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
