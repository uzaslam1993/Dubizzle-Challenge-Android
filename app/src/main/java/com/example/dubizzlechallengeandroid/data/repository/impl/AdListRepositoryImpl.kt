package com.example.dubizzlechallengeandroid.data.repository.impl

import com.example.dubizzlechallengeandroid.common.AdListMapper
import com.example.dubizzlechallengeandroid.data.dao.AdListBackendDao
import com.example.dubizzlechallengeandroid.data.repository.AdListRepository
import com.example.dubizzlechallengeandroid.data.repository.vo.AdVO
import io.reactivex.Observable

class AdListRepositoryImpl(private val backendDao: AdListBackendDao, val mapper: AdListMapper) :
    AdListRepository {
    override fun getAdList(): Observable<List<AdVO>> =
        backendDao.getAdList().flatMap { Observable.just(mapper.toAdVO(it)) }
}