package com.example.dubizzlechallengeandroid.data.dao.backend.dto

import com.example.dubizzlechallengeandroid.data.dao.backend.dto.AdDTO
import com.google.gson.annotations.SerializedName

data class ListingResponse(
    @SerializedName("results")
    val adList: List<AdDTO>
)