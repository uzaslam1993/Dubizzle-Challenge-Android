package com.example.dubizzlechallengeandroid.ui.presenter

import com.example.dubizzlechallengeandroid.data.repository.vo.AdVO
import com.example.dubizzlechallengeandroid.domain.GetAdListUseCase
import com.example.dubizzlechallengeandroid.ui.base.BasePresenterImpl
import com.example.dubizzlechallengeandroid.ui.base.RxBaseProcessor
import com.example.dubizzlechallengeandroid.ui.view.activity.AdListActivityContract
import io.reactivex.observers.DisposableObserver

class AdListPresenterImpl(
    private val getAdlistUseCase: GetAdListUseCase,
    rxBaseProcessor: RxBaseProcessor
) : AdListPresenter, BasePresenterImpl<AdListActivityContract>(rxBaseProcessor) {


    override fun onDetach() {
        baseProcessor.clear()
    }

    override fun onAttach() {
        view.showLoading()
        val callback = object : DisposableObserver<List<AdVO>>() {
            override fun onComplete() {

            }

            override fun onNext(adList: List<AdVO>) {
                view.hideLoading()
                if(adList.isNotEmpty()) {
                    view.showHeading()
                    view.showSearchBar()
                    view.showList(adList)
                }
                else {
                    view.showNoContent()
                }
            }

            override fun onError(e: Throwable) {
                view.hideLoading()
                view.showError()
                view.showNoContent()
            }

        }
        baseProcessor.processList(getAdlistUseCase.getAdList(), callback)
    }
}