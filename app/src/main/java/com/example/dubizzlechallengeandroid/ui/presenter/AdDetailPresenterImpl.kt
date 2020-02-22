package com.example.dubizzlechallengeandroid.ui.presenter

import com.example.dubizzlechallengeandroid.data.repository.vo.AdVO
import com.example.dubizzlechallengeandroid.ui.view.activity.AdDetailActivityContract

class AdDetailPresenterImpl : AdDetailPresenter {
    lateinit var view: AdDetailActivityContract

    override fun onAttach(adVO: AdVO) {
        view.renderDate(adVO.date)
        view.renderImage(adVO.largeUrl)
        view.renderPrice(adVO.price)
        view.renderTitle(adVO.name)
    }

    override fun initView(view: AdDetailActivityContract) {
        this.view = view
    }

    override fun onDetach() {
    }
}