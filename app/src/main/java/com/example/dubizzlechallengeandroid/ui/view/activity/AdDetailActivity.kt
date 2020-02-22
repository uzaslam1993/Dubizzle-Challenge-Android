package com.example.dubizzlechallengeandroid.ui.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.dubizzlechallengeandroid.common.Constants
import com.example.dubizzlechallengeandroid.data.repository.vo.AdVO
import com.example.dubizzlechallengeandroid.ui.presenter.AdDetailPresenter
import com.example.dubizzlechallengeandroid.ui.presenter.AdDetailPresenterImpl
import com.example.dubizzlechallengeandroid.R
import kotlinx.android.synthetic.main.activity_detail.*

class AdDetailActivity : AppCompatActivity(), AdDetailActivityContract {
    lateinit var adVO: AdVO
    lateinit var presenter: AdDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        adVO = intent.getSerializableExtra(Constants.AD_OBJECT) as AdVO
        presenter = AdDetailPresenterImpl()
        presenter.initView(this)
        presenter.onAttach(adVO)
    }


    override fun renderPrice(price: String) {
        textViewPrice.text = price
    }

    override fun renderDate(date: String) {
        textViewDate.text = date
    }

    override fun renderTitle(title: String) {
        textViewTitle.text = title
    }

    override fun renderImage(url: String) {
        Glide.with(this).load(url).into(imageViewImage)
    }
}
