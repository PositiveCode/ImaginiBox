package com.geneus.imaginibox.deprecated.main;

import android.content.Context;

public class MainPresenter implements MainContract.Presenter {
    private Context context;
    private MainContract.View mView;

    public MainPresenter(Context context, MainContract.View mView) {
        this.context = context;
        this.mView = mView;
        mView.setPresenter(this);
    }

    @Override
    public void onTwoByTwo() {
        mView.showTwoByTwo();
    }

    @Override
    public void onThreeByThree() {
        mView.showThreeByThree();
    }
}
