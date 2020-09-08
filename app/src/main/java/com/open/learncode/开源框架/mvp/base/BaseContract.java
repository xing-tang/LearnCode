package com.open.learncode.开源框架.mvp.base;

public class BaseContract {

    public interface View {

        void showLoading();

        void hideLoading();

    }

    public interface Presenter<V extends View> {

        void attachView(V view);

        void detachView();

    }
}
