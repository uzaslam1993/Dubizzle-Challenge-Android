package com.example.dubizzlechallengeandroid.domain

import com.example.dubizzlechallengeandroid.common.AdListMapper
import com.example.dubizzlechallengeandroid.data.dao.AdListBackendDao
import com.example.dubizzlechallengeandroid.data.dao.backend.impl.AdListBackendDaoImpl
import com.example.dubizzlechallengeandroid.data.dao.backend.impl.retrofit.DubizzleListingAPI
import com.example.dubizzlechallengeandroid.data.repository.AdListRepository
import com.example.dubizzlechallengeandroid.data.repository.impl.AdListRepositoryImpl
import com.example.dubizzlechallengeandroid.data.repository.vo.AdVO
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetAdListUseCaseImplTest {

    @Mock
    lateinit var repository: AdListRepository
    lateinit var useCase: GetAdListUseCase


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        useCase = GetAdListUseCaseImpl(repository)
    }

    @Test
    fun getAdListCalledInRepository_correctResponseIsDelivered() {

        val adListResponse = listOf<AdVO>()
        Mockito.`when`(repository.getAdList()).thenReturn(Observable.just(listOf<AdVO>()))

        val testObserver = useCase.getAdList().test()

        testObserver.assertValue(adListResponse)
    }
}