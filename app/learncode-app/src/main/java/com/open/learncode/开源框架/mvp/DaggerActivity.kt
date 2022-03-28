package com.open.learncode.开源框架.mvp

import com.open.learncode.开源框架.mvp.base.BasePresenterActivity
import com.open.learncode.开源框架.mvp.presenter.Contract
import com.open.learncode.开源框架.mvp.presenter.DaggerPresenter
import com.open.learncode.开源框架.mvp.presenter.Model

class DaggerActivity : BasePresenterActivity<Model, DaggerPresenter, Contract.View>() {


    override fun showLoading() {

    }

    override fun hideLoading() {

    }

}
