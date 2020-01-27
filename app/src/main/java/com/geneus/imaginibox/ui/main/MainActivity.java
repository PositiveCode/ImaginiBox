package com.geneus.imaginibox.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.geneus.imaginibox.R;
import com.geneus.imaginibox.ui.BiDirectionScrollView;
import com.geneus.imaginibox.ui.CanvasView;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private RelativeLayout rlCanvas;
    private Button btnTwoByTwo;
    private Button btnThreeByThree;
    private MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MainPresenter(this, this);

        initView();
        initCanvas();
        initClickListener();
    }

    private void initCanvas() {
        CanvasView canvasView = new CanvasView(this, false);
        rlCanvas.addView(canvasView);
    }

    private void initView(){
        rlCanvas = findViewById(R.id.rlCanvas);
        btnThreeByThree = findViewById(R.id.btnThreeByThree);
        btnTwoByTwo = findViewById(R.id.btnTwoByTwo);
    }

    private void initClickListener(){
        btnThreeByThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnThreeByThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
