package com.geneus.imaginibox.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.geneus.imaginibox.R;
import com.geneus.imaginibox.ui.MyCanvasView;
import com.geneus.imaginibox.ui.MyImageView;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout rlCanvas;
    private Button btnTwoByTwo;
    private Button btnThreeByThree;
    private MyCanvasView myCanvasView;
    private MyImageView myImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initCanvas();
        initClickListener();

        Toast.makeText(this, "Pinch to zoom in or zoom out...", Toast.LENGTH_SHORT).show();
    }

    private void initCanvas() {
//        myCanvasView = new MyCanvasView(this, false);
//        rlCanvas.addView(myCanvasView);
        myImageView = new MyImageView(this);
        rlCanvas.addView(myImageView);
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
                myCanvasView.setTwoByTwo(false);
            }
        });

        btnTwoByTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCanvasView.setTwoByTwo(true);
            }
        });
    }
}
