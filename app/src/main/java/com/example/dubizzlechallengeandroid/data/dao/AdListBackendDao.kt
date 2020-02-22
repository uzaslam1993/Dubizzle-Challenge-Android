package com.example.dubizzlechallengeandroid.data.dao

import com.example.dubizzlechallengeandroid.data.dao.backend.dto.ListingResponse
import io.reactivex.Observable

interface AdListBackendDao {
    fun getAdList(): Observable<ListingResponse>
}