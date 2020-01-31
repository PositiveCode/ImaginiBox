package com.geneus.imaginibox.ui.main;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.geneus.imaginibox.R;
import com.geneus.imaginibox.ui.viewComponents.TriSquareLinearLayout;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private LinearLayout llCanvas;
    private Button btnTwoByTwo;
    private Button btnThreeByThree;
    private MainContract.Presenter mPresenter;

    private TriSquareLinearLayout triSquareLinearLayout1;
    private TriSquareLinearLayout triSquareLinearLayout2;
    private TriSquareLinearLayout triSquareLinearLayout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MainPresenter(this, this);

        initView();
        initClickListener();

        Toast.makeText(this, "Tap on the box to see images with different filters.. ", Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        llCanvas = findViewById(R.id.llCanvas);
        btnThreeByThree = findViewById(R.id.btnThreeByThree);
        btnTwoByTwo = findViewById(R.id.btnTwoByTwo);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        triSquareLinearLayout1 = new TriSquareLinearLayout(this);
        triSquareLinearLayout2 = new TriSquareLinearLayout(this);
        triSquareLinearLayout3 = new TriSquareLinearLayout(this);

        llCanvas.addView(triSquareLinearLayout1, params);
        llCanvas.addView(triSquareLinearLayout2, params);
        llCanvas.addView(triSquareLinearLayout3, params);
    }

    private void initClickListener() {
        btnThreeByThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onThreeByThree();
            }
        });

        btnTwoByTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onTwoByTwo();
            }
        });
    }


    @Override
    public void showTwoByTwo() {
        triSquareLinearLayout3.setVisibility(View.GONE);
        //set visibility of last image view to gone.
        triSquareLinearLayout1.getChildAt(triSquareLinearLayout1.getChildCount() - 1).setVisibility(View.GONE);
        triSquareLinearLayout2.getChildAt(triSquareLinearLayout2.getChildCount() - 1).setVisibility(View.GONE);
    }

    @Override
    public void showThreeByThree() {
        triSquareLinearLayout3.setVisibility(View.VISIBLE);
        triSquareLinearLayout1.getChildAt(triSquareLinearLayout1.getChildCount() - 1).setVisibility(View.VISIBLE);
        triSquareLinearLayout2.getChildAt(triSquareLinearLayout2.getChildCount() - 1).setVisibility(View.VISIBLE);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
