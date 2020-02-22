package com.example.dubizzlechallengeandroid.ui.presenter

import com.example.dubizzlechallengeandroid.data.repository.vo.AdVO
import com.example.dubizzlechallengeandroid.ui.view.activity.AdDetailActivityContract
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class AdDetailPresenterImplTest {

    @Mock
    lateinit var view: AdDetailActivityContract

    lateinit var adDetailPresenter: AdDetailPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        adDetailPresenter = AdDetailPresenterImpl()
        adDetailPresenter.initView(view)
    }


    @Test
    fun onAttach_renderMethodsInViewAreCalled() {
        val adVO = AdVO(
            "sunglasses",
            "www.image.com",
            "5 AED",
            "21-02-02",
            "largeurl.com"
        )
        adDetailPresenter.onAttach(adVO)
        Mockito.verify(view).renderDate(Mockito.anyString())
        Mockito.verify(view).renderImage(Mockito.anyString())
        Mockito.verify(view).renderPrice(Mockito.anyString())
        Mockito.verify(view).renderTitle(Mockito.anyString())
    }
}