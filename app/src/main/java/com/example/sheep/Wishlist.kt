package com.example.sheep


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WishlistGame")
class WishlistGame {
    @PrimaryKey(autoGenerate = false)
    var dealID: Int = 0
    var internalName: String = ""
    var title: String = ""
    var metacriticLink: String = ""
    var storeID: String = ""
    var gameID: String = ""
    var lastPrice: Float = 0.0f
    var salePrice: Float = 0.0f
    var normalPrice: String = ""
    var OnSale: String = ""
    var savings: String = ""
    var metacriticScore: String = ""
    var steamRatingText: String = ""
    var steamRatingPercent: String = ""
    var steamRatingCount: String = ""
    var steamAppID: String = ""
    var releaseDate: Long = 0
    var lastChange: Long = 0
    var dealRating: String = ""
    var thumb: String = ""

    constructor() : this(
        0,
        "",
        "",
        "",
        "",
        "",
        0.0f,
        0.0f,
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        0,
        0,
        "",
        ""
    )
    constructor(
        dealID: Int,
        internalName: String,
        title: String,
        metacriticLink: String,
        storeID: String,
        gameID: String ,
        lastPrice: Float,
        salePrice: Float,
        normalPrice: String,
        OnSale: String,
        savings: String,
        metacriticScore: String,
        steamRatingText: String,
        steamRatingPercent: String,
        steamRatingCount: String,
        steamAppID: String,
        releaseDate: Long,
        lastChange: Long,
        dealRating: String,
        thumb: String
    )
    {
        this.dealID = dealID
        this.internalName = internalName
        this.title = title
        this.metacriticLink = metacriticLink
        this.storeID = storeID
        this.gameID = gameID
        this.lastPrice = lastPrice
        this.salePrice = salePrice
        this.normalPrice = normalPrice
        this.OnSale = OnSale
        this.savings = savings
        this.metacriticScore = metacriticScore
        this.steamRatingText = steamRatingText
        this.steamRatingPercent = steamRatingPercent
        this.steamRatingCount = steamRatingCount
        this.steamAppID = steamAppID
        this.releaseDate = releaseDate
        this.lastChange = lastChange
        this.dealRating = dealRating
        this.thumb = thumb
    }
}



/*
var WishlistDeals = listOf(
    WishlistGame(
        internalName = "DEUSEXHUMANREVOLUTIONDIRECTORSCUT",
        title = "Deus Ex Human Revoluti",
        metacriticLink = "/game/pc/deus-ex-human-revolution---directors-cut",
        dealID = 2,
        storeID = "1",
        gameID = "102249",
        lastPrice = 10f,
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
    ),
    WishlistGame(
        internalName = "DEUSEXHUMANREVOLUTIONDIRECTORSCUT",
        title = "Deus Ex Human Revoluti",
        metacriticLink = "/game/pc/deus-ex-human-revolution---directors-cut",
        dealID = 2,
        storeID = "1",
        gameID = "102249",
        lastPrice = 10f,
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
)*/