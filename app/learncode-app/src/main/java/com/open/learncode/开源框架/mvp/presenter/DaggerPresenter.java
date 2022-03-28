package com.open.learncode.开源框架.mvp.presenter;

import com.open.learncode.开源框架.mvp.base.BasePresenter;

public class DaggerPresenter extends BasePresenter<Model,Contract.View> implements Contract.Presenter {

    public DaggerPresenter(Model model) {
        super(model);
    }
}
