package com.geneus.imaginibox.ui.main;

import android.content.Context;

public class MainPresenter implements MainContract.Presenter {
    private Context context;
    private MainContract.View mView;

    public MainPresenter(Context context, MainContract.View mView) {
        this.context = context;
        this.mView = mView;
        mView.setPresenter(this);
    }
}
