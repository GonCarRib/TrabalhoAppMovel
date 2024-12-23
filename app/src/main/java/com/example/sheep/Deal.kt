package com.example.sheep

import com.google.gson.annotations.SerializedName

data class GameDeal(

    @SerializedName("internalName")
    val internalName: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("metacriticLink")
    var metacriticLink: String,

    @SerializedName("dealID")
    val dealID: String,

    @SerializedName("storeID")
    val storeID: String,

    @SerializedName("gameID")
    val gameID: String,

    @SerializedName("salePrice")
    val salePrice: String,

    @SerializedName("normalPrice")
    val normalPrice: String,

    @SerializedName("OnSale")
    val OnSale: String,

    @SerializedName("savings")
    val savings: String,

    @SerializedName("metacriticScore")
    val metacriticScore: String,

    @SerializedName("steamRatingText")
    var steamRatingText: String,

    @SerializedName("steamRatingPercent")
    val steamRatingPercent: String,

    @SerializedName("steamRatingCount")
    val steamRatingCount: String,

    @SerializedName("steamAppID")
    var steamAppID: String,

    @SerializedName("releaseDate")
    val releaseDate: Long,

    @SerializedName("lastChange")
    val lastChange: Long,

    @SerializedName("dealRating")
    val dealRating: String,
    
    @SerializedName("thumb")
    val thumb: String
)

/*
var gameDeals = List(20) { y ->
    GameDeal(
        internalName = "DEUSEXHUMANREVOLUTIONDIRECTORSCUT",
        title = "Deus Ex Human Revoluti",
        metacriticLink = "/game/pc/deus-ex-human-revolution---directors-cut",
        dealID = 6,
        storeID = "1",
        gameID = "102249",
        salePrice = 2.99f,
        normalPrice = "19.99",
        OnSale = "1",
        savings = "85.042521",
        metacriticScore = "91",
        steamRatingText = "Very Positive",
        steamRatingPercent = "92",
        steamRatingCount = "17993",
        steamAppID = "238010",
        releaseDate = 1382400000,
        lastChange = 1621536418,
        dealRating = "9.6",
        thumb = "https://cdn.cloudflare.steamstatic.com/steam/apps/238010/capsule_sm_120.jpg?t=1619788192"
    )
    GameDeal(
        internalName = "DEUSEXHUMANREVOLUTIONDIRECTORSCUT",
        title = "Deus Ex Human Revoluti",
        metacriticLink = "/game/pc/deus-ex-human-revolution---directors-cut",
        dealID = 4,
        storeID = "1",
        gameID = "102249",
        salePrice = 20f,
        normalPrice = "19.99",
        OnSale = "1",
        savings = "85.042521",
        metacriticScore = "91",
        steamRatingText = "Very Positive",
        steamRatingPercent = "92",
        steamRatingCount = "17993",
        steamAppID = "238010",
        releaseDate = 1382400000,
        lastChange = 1621536418,
        dealRating = "9.6",
        thumb = "https://cdn.cloudflare.steamstatic.com/steam/apps/238010/capsule_sm_120.jpg?t=1619788192"
    )
}*/


