package com.example.sheep

sealed interface WishEvent {
    data object SaveWish : WishEvent

    data class SetDealID(val dealID: Int) : WishEvent
    data class SetInternalName(val internalName: String) : WishEvent
    data class SetTitle(val title: String) : WishEvent
    data class SetMetacriticLink(val metacriticLink: String) : WishEvent
    data class SetStoreID(val storeID: String) : WishEvent
    data class SetGameID(val gameID: String) : WishEvent
    data class SetLastPrice(var lastPrice: Float) : WishEvent
    data class SetSalePrice(val salePrice: Float) : WishEvent
    data class SetNormalPrice(val normalPrice: String) : WishEvent
    data class SetIsOnSale(val isOnSale: String) : WishEvent
    data class SetSavings(val savings: String) : WishEvent
    data class SetMetacriticScore(val metacriticScore: String) : WishEvent
    data class SetSteamRatingText(val steamRatingText: String) : WishEvent
    data class SetSteamRatingPercent(val steamRatingPercent: String) : WishEvent
    data class SetSteamRatingCount(val steamRatingCount: String) : WishEvent
    data class SetSteamAppID(val steamAppID: String) : WishEvent
    data class SetReleaseDate(val releaseDate: Long) : WishEvent
    data class SetLastChange(val lastChange: Long) : WishEvent
    data class SetDealRating(val dealRating: String) : WishEvent
    data class SetThumb(val thumb: String) : WishEvent

    data class DeleteWish(val wish : wishlistGame) : WishEvent

}

