package com.example.dubizzlechallengeandroid.data.dao.backend.impl.retrofit

import com.example.dubizzlechallengeandroid.data.dao.backend.dto.ListingResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface DubizzleListingAPI {

    @GET("/default/dynamodb-writer")
    fun getAdList(
    ): Observable<Response<ListingResponse>>
}