package com.example.dubizzlechallengeandroid.ui.view.activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dubizzlechallengeandroid.R
import com.example.dubizzlechallengeandroid.common.Constants
import com.example.dubizzlechallengeandroid.data.repository.vo.AdVO
import com.example.dubizzlechallengeandroid.di.AdListActivityModule
import com.example.dubizzlechallengeandroid.di.DaggerAdListActivityComponent
import com.example.dubizzlechallengeandroid.ui.presenter.AdListPresenter
import com.example.dubizzlechallengeandroid.ui.view.adapter.AdListAdapter
import com.example.dubizzlechallengeandroid.ui.view.callback.AdSelectedListener
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class AdListActivity : AppCompatActivity(), AdListActivityContract, AdSelectedListener {

    private lateinit var adListAdapter: AdListAdapter
    private var adList: ArrayList<AdVO> = ArrayList()

    @Inject
    lateinit var presenter: AdListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activityComponent = DaggerAdListActivityComponent.builder()
            .adListActivityModule(AdListActivityModule(this))
            .build()

        activityComponent.inject(this)
        presenter.initView(this)
        presenter.onAttach()
        initRecyclerView()

    }

    private fun initRecyclerView() {
        adListRecyclerView.layoutManager = LinearLayoutManager(this)
        adListAdapter = AdListAdapter(this, adList, this)
        adListRecyclerView.adapter = adListAdapter
    }

    override fun showList(adList: List<AdVO>) {
        this.adList.clear()
        this.adList.addAll(adList)
        adListAdapter.notifyDataSetChanged()
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showNoContent() {
        textViewNoItemsFound.visibility = View.VISIBLE
    }

    override fun showNoConnection() {
        Snackbar.make(
            ad_list_root,
            R.string.no_internet,
            Snackbar.LENGTH_LONG
        ).show()
    }

    override fun showError() {
        Snackbar.make(
            ad_list_root,
            R.string.error_generic_message,
            Snackbar.LENGTH_LONG
        ).show()
    }

    override fun onAdSelected(adVO: AdVO) {
        val intent = Intent(this, AdDetailActivity::class.java)
        intent.putExtra(Constants.AD_OBJECT, adVO)
        startActivity(intent)
    }

    override fun showSearchBar() {
        editTextSearch.visibility = View.VISIBLE
        editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(char: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    adListAdapter.filter.filter(char)

            }

        })
    }

    override fun showHeading() {
        textViewHeading.visibility = View.VISIBLE
    }
}
