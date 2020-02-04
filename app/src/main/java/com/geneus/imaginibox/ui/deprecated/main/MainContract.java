package com.geneus.imaginibox.ui.deprecated.main;

import com.geneus.imaginibox.base.BaseView;

public interface MainContract {
    interface View extends BaseView<Presenter> {
        void showTwoByTwo();
        void showThreeByThree();
    }

    interface Presenter {
        void onTwoByTwo();
        void onThreeByThree();
    }
}
