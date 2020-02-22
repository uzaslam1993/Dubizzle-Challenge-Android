package com.example.dubizzlechallengeandroid.di

import com.example.dubizzlechallengeandroid.ui.view.activity.AdListActivity
import dagger.Component


@Component(modules = arrayOf(AdListActivityModule::class, UseCaseModule::class, RepositoryModule::class))
interface AdListActivityComponent {

    fun inject(mainActivity: AdListActivity)

}