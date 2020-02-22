package com.example.dubizzlechallengeandroid.ui.view.callback

import com.example.dubizzlechallengeandroid.data.repository.vo.AdVO

interface AdSelectedListener {

    fun onAdSelected(adVO: AdVO)
}