package com.example.dubizzlechallengeandroid.ui.view.activity

import com.example.dubizzlechallengeandroid.ui.base.BaseView

interface AdDetailActivityContract : BaseView {
    fun renderPrice(price: String)
    fun renderDate(date: String)
    fun renderTitle(title: String)
    fun renderImage(url: String)
}