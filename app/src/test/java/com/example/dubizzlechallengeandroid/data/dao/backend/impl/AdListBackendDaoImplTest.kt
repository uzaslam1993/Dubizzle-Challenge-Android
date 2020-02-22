package com.example.dubizzlechallengeandroid.data.dao.backend.impl

import com.example.dubizzlechallengeandroid.common.AppException
import com.example.dubizzlechallengeandroid.common.ErrorCodes
import com.example.dubizzlechallengeandroid.data.dao.AdListBackendDao
import com.example.dubizzlechallengeandroid.data.dao.backend.dto.AdDTO
import com.example.dubizzlechallengeandroid.data.dao.backend.dto.ListingResponse
import com.example.dubizzlechallengeandroid.data.dao.backend.impl.retrofit.DubizzleListingAPI
import io.reactivex.Observable
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

class AdListBackendDaoImplTest {

    @Mock
    lateinit var dubizzleListingAPI: DubizzleListingAPI

    lateinit var adListBackendDao: AdListBackendDao

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        adListBackendDao = AdListBackendDaoImpl(dubizzleListingAPI)
    }

    @Test
    fun getAdList_whenResponseIsSuccess_returnsAdListInResponseBody(){
        //arrange
        val adListResponse = ListingResponse(mutableListOf())
        Mockito.`when`(dubizzleListingAPI.getAdList())
            .thenReturn(Observable.just(Response.success(adListResponse)))

        //act
        val testObserver = adListBackendDao.getAdList().test()

        //assert
        testObserver.assertValue(adListResponse)
    }


    @Test
    fun getAdList_whenResponseIsError_returnsErrorInBody() {

        //arrange
        val error = AppException(ErrorCodes.BACKEND_ERROR, "error")
        Mockito.`when`(dubizzleListingAPI.getAdList())
            .thenReturn(
                Observable.just(
                    Response.error(
                        ErrorCodes.BACKEND_ERROR,
                        ResponseBody.create(null, "error")
                    )
                )
            )

        //act
        val testObserver = adListBackendDao.getAdList().test()

        //assert
        testObserver.assertError(error)
    }
}