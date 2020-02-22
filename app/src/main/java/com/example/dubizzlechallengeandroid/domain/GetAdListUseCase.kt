package com.example.dubizzlechallengeandroid.domain

import com.example.dubizzlechallengeandroid.data.repository.AdListRepository
import com.example.dubizzlechallengeandroid.data.repository.vo.AdVO
import io.reactivex.Observable

interface GetAdListUseCase {
    fun getAdList(): Observable<List<AdVO>>
}

class GetAdListUseCaseImpl(val adListRepository: AdListRepository) : GetAdListUseCase {
    override fun getAdList(): Observable<List<AdVO>> =
        adListRepository.getAdList()

}