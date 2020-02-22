package com.example.dubizzlechallengeandroid.ui.presenter;

import com.example.dubizzlechallengeandroid.data.repository.vo.AdVO;
import com.example.dubizzlechallengeandroid.ui.view.activity.AdDetailActivityContract;

import org.jetbrains.annotations.NotNull;

public class AdDetailPresenterImpl implements AdDetailPresenter {

    private AdDetailActivityContract view;


    @Override
    public void onAttach(@NotNull AdVO adVO) {
        view.renderDate(adVO.getDate());
        view.renderImage(adVO.getLargeUrl());
        view.renderPrice(adVO.getPrice());
        view.renderTitle(adVO.getName());
    }

    @Override
    public void initView(@NotNull AdDetailActivityContract view) {
        this.view = view;
    }

    @Override
    public void onDetach() {

    }
}
