package com.example.dubizzlechallengeandroid.ui.presenter

import com.example.dubizzlechallengeandroid.ui.base.BasePresenter
import com.example.dubizzlechallengeandroid.ui.view.activity.AdListActivityContract

interface AdListPresenter : BasePresenter<AdListActivityContract> {
    fun onAttach()
}