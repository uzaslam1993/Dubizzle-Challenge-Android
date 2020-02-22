package com.example.dubizzlechallengeandroid.data.dao.backend.dto

import com.google.gson.annotations.SerializedName

data class AdDTO(
    @SerializedName("created_at")val createdAt: String,
    val price: String,
    val name: String,
    val uid: String,
    @SerializedName("image_ids") val imageIds: ArrayList<String>,
    @SerializedName("image_urls") val imageUrls: ArrayList<String>,
    @SerializedName("image_urls_thumbnails") val imageUrlsThumbnails: ArrayList<String>
)
