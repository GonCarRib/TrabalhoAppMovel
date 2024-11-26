package com.example.sheep

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GameDeal(
    @PrimaryKey(autoGenerate = false)
    val dealID: Int,
    val internalName: String,
    val title: String,
    val metacriticLink: String,
    val storeID: String,
    val gameID: String,
    val salePrice: Float,
    val normalPrice: String,
    val isOnSale: String,
    val savings: String,
    val metacriticScore: String,
    val steamRatingText: String,
    val steamRatingPercent: String,
    val steamRatingCount: String,
    val steamAppID: String,
    val releaseDate: Long,
    val lastChange: Long,
    val dealRating: String,
    val thumb: String
)

@Entity
data class wishlistGame(
    @PrimaryKey(autoGenerate = false)
    val dealID: Int,
    val internalName: String,
    val title: String,
    val metacriticLink: String,
    val storeID: String,
    val gameID: String,
    var lastPrice : Float,
    val salePrice: Float,
    val normalPrice: String,
    val isOnSale: String,
    val savings: String,
    val metacriticScore: String,
    val steamRatingText: String,
    val steamRatingPercent: String,
    val steamRatingCount: String,
    val steamAppID: String,
    val releaseDate: Long,
    val lastChange: Long,
    val dealRating: String,
    val thumb: String
)


var gameDeals = List(20) { y ->
    GameDeal(
        internalName = "DEUSEXHUMANREVOLUTIONDIRECTORSCUT",
        title = "Deus Ex Human Revoluti",
        metacriticLink = "/game/pc/deus-ex-human-revolution---directors-cut",
        dealID = 2,
        storeID = "1",
        gameID = "102249",
        salePrice = 2.99f,
        normalPrice = "19.99",
        isOnSale = "1",
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
        dealID = 2,
        storeID = "1",
        gameID = "102249",
        salePrice = 20f,
        normalPrice = "19.99",
        isOnSale = "1",
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
}


var wishlistDeals = listOf(
    wishlistGame(
        internalName = "DEUSEXHUMANREVOLUTIONDIRECTORSCUT",
        title = "Deus Ex Human Revoluti",
        metacriticLink = "/game/pc/deus-ex-human-revolution---directors-cut",
        dealID = 2,
        storeID = "1",
        gameID = "102249",
        lastPrice = 10f,
        salePrice = 20f,
        normalPrice = "19.99",
        isOnSale = "1",
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
    wishlistGame(
        internalName = "DEUSEXHUMANREVOLUTIONDIRECTORSCUT",
        title = "Deus Ex Human Revoluti",
        metacriticLink = "/game/pc/deus-ex-human-revolution---directors-cut",
        dealID = 2,
        storeID = "1",
        gameID = "102249",
        lastPrice = 10f,
        salePrice = 2.99f,
        normalPrice = "19.99",
        isOnSale = "1",
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
)
