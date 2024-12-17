package com.example.sheep

import com.google.gson.annotations.SerializedName

data class Store(
    @SerializedName("storeID")
    val storeID: String,
    @SerializedName("storeName")
    val storeName: String,
    @SerializedName("isActive")
    val isActive: Int,
    @SerializedName("images")
    val images: Images
)

data class Images(
    @SerializedName("banner")
    val banner: String,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("icon")
    val icon: String
)
