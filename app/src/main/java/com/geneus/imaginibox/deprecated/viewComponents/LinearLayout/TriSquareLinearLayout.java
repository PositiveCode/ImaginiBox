package com.geneus.imaginibox.deprecated.viewComponents.LinearLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.geneus.imaginibox.deprecated.viewComponents.GPUImageView.TappableGPUImgView;

public class TriSquareLinearLayout extends LinearLayout {

    TappableGPUImgView imgView1;
    TappableGPUImgView imgView2;
    TappableGPUImgView imgView3;

    public TriSquareLinearLayout(Context context) {
        super(context);
        setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(300, 300);
        params.setMargins(50, 50, 0, 50);

        imgView1 = new TappableGPUImgView(context);
        imgView2 = new TappableGPUImgView(context);
        imgView3 = new TappableGPUImgView(context);

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
