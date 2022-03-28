package com.open.learncode.开源框架.mvp.base;

public interface IPresenterFactory<T extends BasePresenter> {
    T createPresenter();
}
