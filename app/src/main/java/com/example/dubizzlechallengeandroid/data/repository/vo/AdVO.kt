package com.example.dubizzlechallengeandroid.data.repository.vo

import java.io.Serializable

data class AdVO(
    val name: String,
    val thumbNailUrl: String,
    val price: String,
    val date: String,
    val largeUrl: String
) : Serializable
