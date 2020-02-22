package com.example.dubizzlechallengeandroid.ui.view.activity

import com.example.dubizzlechallengeandroid.data.repository.vo.AdVO
import com.example.dubizzlechallengeandroid.ui.base.BaseLoadableContentView

interface AdListActivityContract : BaseLoadableContentView {
    fun showList(adList: List<AdVO>)
    fun showSearchBar()
    fun showHeading()
}