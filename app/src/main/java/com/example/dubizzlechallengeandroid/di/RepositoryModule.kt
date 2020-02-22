package com.example.dubizzlechallengeandroid.di


import com.example.dubizzlechallengeandroid.common.AdListMapper
import com.example.dubizzlechallengeandroid.data.dao.AdListBackendDao
import com.example.dubizzlechallengeandroid.data.dao.backend.impl.AdListBackendDaoImpl
import com.example.dubizzlechallengeandroid.data.dao.backend.impl.retrofit.DubizzleListingAPI
import com.example.dubizzlechallengeandroid.data.dao.backend.impl.retrofit.RetrofitFactory
import com.example.dubizzlechallengeandroid.data.repository.AdListRepository
import com.example.dubizzlechallengeandroid.data.repository.impl.AdListRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideRepository(
        adListBackendDao: AdListBackendDao,
        mapper: AdListMapper
    ): AdListRepository {
        return AdListRepositoryImpl(adListBackendDao, mapper)
    }

    @Provides
    fun provideBackendDaoImpl(): AdListBackendDao {
        return AdListBackendDaoImpl(
            RetrofitFactory.getDefaultRetrofit()
                .create(DubizzleListingAPI::class.java)
        )
    }

    @Provides
    fun provideMapper(): AdListMapper {
        return AdListMapper
    }
}