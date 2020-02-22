package com.example.dubizzlechallengeandroid.di

import com.example.dubizzlechallengeandroid.ui.view.activity.AdDetailActivity
import dagger.Component

@Component(modules = [AdDetailActivityModule::class])
interface AdDetailActivityComponent {

    fun inject(mainActivity: AdDetailActivity)
}