package com.open.learncode.开源框架.mvp.base;


public class BasePresenter<M extends BaseModel, V extends BaseContract.View> implements BaseContract.Presenter<V> {

    private V view;
    private M model;

    public BasePresenter(M model) {
        this.model = model;
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
