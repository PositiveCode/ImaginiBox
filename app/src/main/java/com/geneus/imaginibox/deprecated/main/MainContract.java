package com.geneus.imaginibox.deprecated.main;

import com.geneus.imaginibox.deprecated.base.BaseView;

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
