package com.example.dubizzlechallengeandroid.ui.base

import com.example.dubizzlechallengeandroid.ui.base.BaseView

interface BaseLoadableContentView : BaseView {
    fun showLoading()
    fun hideLoading()
    fun showNoContent()
    fun showNoConnection()
    fun showError()
}
