package com.open.learncode.开源框架.mvp.presenter;

import com.open.learncode.开源框架.mvp.base.BaseContract;

public class Contract {

    public interface View extends BaseContract.View {

    }

    public interface Presenter extends BaseContract.Presenter<View> {

    }
}
