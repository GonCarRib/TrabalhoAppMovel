package com.example.sheep

import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {

    @GET("api/1.0/deals")
    fun getDeals() : Call<List<GameDeal>>

    @GET("/api/1.0/stores")
    fun getStores() : Call<List<Store>>
}