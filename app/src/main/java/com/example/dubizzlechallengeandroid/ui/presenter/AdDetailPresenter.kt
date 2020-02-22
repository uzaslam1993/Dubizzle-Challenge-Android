package com.example.dubizzlechallengeandroid.ui.presenter

import com.example.dubizzlechallengeandroid.data.repository.vo.AdVO
import com.example.dubizzlechallengeandroid.ui.base.BasePresenter
import com.example.dubizzlechallengeandroid.ui.view.activity.AdDetailActivityContract

interface AdDetailPresenter : BasePresenter<AdDetailActivityContract> {
    fun onAttach(adVO: AdVO)


}