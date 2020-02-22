package com.example.dubizzlechallengeandroid.di

import android.app.Activity
import com.example.dubizzlechallengeandroid.ui.presenter.AdDetailPresenter
import com.example.dubizzlechallengeandroid.ui.presenter.AdDetailPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class AdDetailActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter():
            AdDetailPresenter {
        return AdDetailPresenterImpl()
    }
}