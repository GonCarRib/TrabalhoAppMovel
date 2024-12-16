package com.example.sheep


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WishlistGame")
class WishlistGame {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0;
    var internalName: String = ""
    var title: String = ""
    var metacriticLink: String = ""
    var dealID: String = ""
    var storeID: String = ""
    var gameID: String = ""
    var lastPrice: Float = 0.0f
    var salePrice: String = ""
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
        "",
        "",
        "",
        "",
        "",
        "",
        0.0f,
        "",
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

        internalName: String,
        title: String,
        metacriticLink: String,
        dealID: String,
        storeID: String,
        gameID: String,
        lastPrice: Float,
        salePrice: String,
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


