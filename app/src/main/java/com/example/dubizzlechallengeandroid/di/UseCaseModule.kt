package com.example.dubizzlechallengeandroid.di

import com.example.dubizzlechallengeandroid.data.repository.AdListRepository
import com.example.dubizzlechallengeandroid.domain.GetAdListUseCase
import com.example.dubizzlechallengeandroid.domain.GetAdListUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideUseCase(adListRepository: AdListRepository): GetAdListUseCase {
        return GetAdListUseCaseImpl(adListRepository)
    }
}