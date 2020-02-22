package com.example.dubizzlechallengeandroid.ui.view.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.dubizzlechallengeandroid.R;
import com.example.dubizzlechallengeandroid.common.Constants;
import com.example.dubizzlechallengeandroid.data.repository.vo.AdVO;
import com.example.dubizzlechallengeandroid.ui.presenter.AdDetailPresenter;
import com.example.dubizzlechallengeandroid.ui.presenter.AdDetailPresenterImpl;

import org.jetbrains.annotations.NotNull;

public class AdDetailActivity extends AppCompatActivity implements AdDetailActivityContract {

    private TextView textViewPrice;
    private TextView textViewDate;
    private TextView textViewTitle;
    private ImageView image;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        AdVO adVO = (AdVO) getIntent().getSerializableExtra(Constants.AD_OBJECT);
        textViewPrice = findViewById(R.id.textViewPrice);
        textViewDate = findViewById(R.id.textViewDate);
        textViewTitle = findViewById(R.id.textViewAdName);
        image = findViewById(R.id.imageViewImage);
        AdDetailPresenter presenter = new AdDetailPresenterImpl();
        presenter.initView(this);
        presenter.onAttach(adVO);
    }

    @Override
    public void renderPrice(@NotNull String price) {
        textViewPrice.setText(price);
    }

    @Override
    public void renderDate(@NotNull String date) {
        textViewDate.setText(date);
    }

    @Override
    public void renderTitle(@NotNull String title) {
        textViewTitle.setText(title);
    }

    @Override
    public void renderImage(@NotNull String url) {
        Glide.with(this).load(url).into(image);
    }
}
