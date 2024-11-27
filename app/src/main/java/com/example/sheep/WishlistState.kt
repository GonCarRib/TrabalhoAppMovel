package com.example.sheep

data class WishlistState(
    val wishlist: List<wishlistGame> = emptyList(),
    val dealID: Int = 0,
    val internalName: String = "",
    val title: String = "",
    val metacriticLink: String = "",
    val storeID: String = "",
    val gameID: String = "",
    var lastPrice: Float = 0.0f,
    val salePrice: Float = 0.0f,
    val normalPrice: String = "",
    val isOnSale: String = "",
    val savings: String = "",
    val metacriticScore: String = "",
    val steamRatingText: String = "",
    val steamRatingPercent: String = "",
    val steamRatingCount: String = "",
    val steamAppID: String = "",
    val releaseDate: Long = 0L,
    val lastChange: Long = 0L,
    val dealRating: String = "",
    val thumb: String = "",
    val isAddingWish:Boolean= false


)
