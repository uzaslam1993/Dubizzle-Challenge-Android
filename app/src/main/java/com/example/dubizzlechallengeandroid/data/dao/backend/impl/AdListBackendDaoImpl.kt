package com.example.dubizzlechallengeandroid.data.dao.backend.impl

import com.example.dubizzlechallengeandroid.common.AppException
import com.example.dubizzlechallengeandroid.common.ErrorCodes
import com.example.dubizzlechallengeandroid.data.dao.AdListBackendDao
import com.example.dubizzlechallengeandroid.data.dao.backend.dto.ApiErrorResponse
import com.example.dubizzlechallengeandroid.data.dao.backend.dto.ApiResponse
import com.example.dubizzlechallengeandroid.data.dao.backend.dto.ApiSuccessResponse
import com.example.dubizzlechallengeandroid.data.dao.backend.dto.ListingResponse
import com.example.dubizzlechallengeandroid.data.dao.backend.impl.retrofit.DubizzleListingAPI
import io.reactivex.Observable

class AdListBackendDaoImpl(private val api: DubizzleListingAPI) : AdListBackendDao {
    override fun getAdList(): Observable<ListingResponse> = api.getAdList()
        .map { ApiResponse.create(it) }
        .flatMap { apiResponse: ApiResponse<ListingResponse> ->
            when (apiResponse) {
                is ApiSuccessResponse -> Observable.just(apiResponse.body)
                is ApiErrorResponse -> Observable.error(
                    AppException(
                        ErrorCodes.BACKEND_ERROR,
                        apiResponse.errorMessage
                    )
                )
                else -> Observable.error(
                    AppException(
                        ErrorCodes.GENERIC_ERROR,
                        "generic error"
                    )
                )
            }
        }
}