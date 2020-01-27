package com.geneus.imaginibox.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.geneus.imaginibox.R;
import com.geneus.imaginibox.ui.CanvasView;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private RelativeLayout rlCanvas;
    private MainContract.Presenter mPresenter;

    public ScrollView scrollView;
    public HorizontalScrollView horizontalScrollView;
    public LinearLayout linearLayout;
    public Canvas mCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        linearLayout = new LinearLayout(this);
        scrollView = new ScrollView(this);
        horizontalScrollView = new HorizontalScrollView(this);


        scrollView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT));

        horizontalScrollView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT));

        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        linearLayout.setOrientation(LinearLayout.VERTICAL);

        Bitmap mBitmap = Bitmap.createBitmap(800, 800, Bitmap.Config.ARGB_8888);

        mCanvas = new Canvas(mBitmap);

        CanvasView canvasView = new CanvasView(this, mCanvas);

        canvasView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT));

        scrollView.addView(canvasView);
        horizontalScrollView.addView(scrollView);

        setContentView(horizontalScrollView);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
