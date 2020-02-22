package com.example.dubizzlechallengeandroid.ui.presenter

import com.example.dubizzlechallengeandroid.data.repository.vo.AdVO
import com.example.dubizzlechallengeandroid.domain.GetAdListUseCase
import com.example.dubizzlechallengeandroid.ui.base.RxBaseProcessor
import com.example.dubizzlechallengeandroid.ui.view.activity.AdListActivityContract
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class AdListPresenterImplTest {

    @Mock
    lateinit var getAdListUseCase: GetAdListUseCase

    @Mock
    lateinit var adlistView: AdListActivityContract

    lateinit var presenter: AdListPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = AdListPresenterImpl(
            getAdListUseCase,
            RxBaseProcessor(Schedulers.trampoline(), Schedulers.trampoline())
        )
        presenter.initView(adlistView)
    }

    @Test
    fun onAttach_WithSuccessValue_showListInViewIsCalled() {

        //Arrange
        val adsList = mutableListOf<AdVO>()
        adsList.add(AdVO("sunglasses", "www.zzz.com", "5 AED", "2019-02-02", "www.xyz.com"))
        Mockito.`when`(getAdListUseCase.getAdList()).thenReturn(Observable.just(adsList))

        presenter.onAttach()

        Mockito.verify(adlistView).showLoading()
        Mockito.verify(adlistView).hideLoading()
        Mockito.verify(adlistView).showHeading()
        Mockito.verify(adlistView).showSearchBar()
        Mockito.verify(adlistView).showList(adsList)
    }

    @Test
    fun onAttach_WithErrorValue_showErrorInViewIsCalled() {

        //Arrange
        Mockito.`when`(getAdListUseCase.getAdList()).thenReturn(Observable.error(Exception()))

        //Act
        presenter.onAttach()


        //assert
        Mockito.verify(adlistView).showLoading()
        Mockito.verify(adlistView).hideLoading()
        Mockito.verify(adlistView).showError()
        Mockito.verify(adlistView).showNoContent()
    }

    @Test
    fun onAttach_WithEmptyList_noContentInViewIsCalled() {

        //Arrange
        val carsList = listOf<AdVO>()
        Mockito.`when`(getAdListUseCase.getAdList()).thenReturn(Observable.just(carsList))

        //Act
        presenter.onAttach()


        //assert
        Mockito.verify(adlistView).showLoading()
        Mockito.verify(adlistView).hideLoading()
        Mockito.verify(adlistView).showNoContent()
    }

}