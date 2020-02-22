package com.example.dubizzlechallengeandroid.data.repository

import com.example.dubizzlechallengeandroid.data.repository.vo.AdVO
import io.reactivex.Observable

interface AdListRepository {
    fun getAdList(): Observable<List<AdVO>>
}