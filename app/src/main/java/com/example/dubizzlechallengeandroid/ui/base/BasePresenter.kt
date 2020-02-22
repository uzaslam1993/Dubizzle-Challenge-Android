package com.example.dubizzlechallengeandroid.ui.base

interface BasePresenter<T : BaseView> {

    fun initView(view: T)

    fun onDetach()
}

abstract class BasePresenterImpl<T : BaseView> constructor(val baseProcessor: RxBaseProcessor) :
    BasePresenter<T> {

    lateinit var view: T

    override fun initView(view: T) {
        this.view = view
    }

    override fun onDetach() {
        baseProcessor.clear()
    }
}