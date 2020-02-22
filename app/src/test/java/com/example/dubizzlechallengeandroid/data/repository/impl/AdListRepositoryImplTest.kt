package com.example.dubizzlechallengeandroid.data.repository.impl

import com.example.dubizzlechallengeandroid.common.AdListMapper
import com.example.dubizzlechallengeandroid.data.dao.AdListBackendDao
import com.example.dubizzlechallengeandroid.data.dao.backend.dto.ListingResponse
import com.example.dubizzlechallengeandroid.data.repository.AdListRepository
import com.example.dubizzlechallengeandroid.data.repository.vo.AdVO
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class AdListRepositoryImplTest {
    @Mock
    lateinit var backendDao: AdListBackendDao

    lateinit var adListRepository: AdListRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        adListRepository = AdListRepositoryImpl(backendDao, AdListMapper)
    }

    @Test
    fun getAdList_repositoryReturnsCorrectResponse() {

        val adListResponse = listOf<AdVO>()
        Mockito.`when`(backendDao.getAdList())
            .thenReturn(Observable.just(ListingResponse(listOf())))

        val testObserver = adListRepository.getAdList().test()

        testObserver.assertValue(adListResponse)


    }
}