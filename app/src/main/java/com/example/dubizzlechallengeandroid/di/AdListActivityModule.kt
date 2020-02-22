package com.example.dubizzlechallengeandroid.di

import android.app.Activity
import com.example.dubizzlechallengeandroid.domain.GetAdListUseCase
import com.example.dubizzlechallengeandroid.ui.base.RxBaseProcessor
import com.example.dubizzlechallengeandroid.ui.presenter.AdListPresenter
import com.example.dubizzlechallengeandroid.ui.presenter.AdListPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class AdListActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(getAdListUseCase: GetAdListUseCase, rxBaseProcessor: RxBaseProcessor):
            AdListPresenter {
        return AdListPresenterImpl(getAdListUseCase, rxBaseProcessor)
    }

    @Provides
    fun provideRxProcessor(): RxBaseProcessor {
        return RxBaseProcessor()
    }


}