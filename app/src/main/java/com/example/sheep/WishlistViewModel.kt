package com.example.sheep

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class WishlistViewModel(
    private val dao: WishDao
) : ViewModel() {

    private val _state = MutableStateFlow(WishlistState())
    private val _wishs = dao.getWishs()


    fun onEvent(event: WishEvent){
        when(event){
            WishEvent.SaveWish ->{
                val dealID = _state.value.dealID
                val internalName = _state.value.internalName
                val title = _state.value.title
                val metacriticLink = _state.value.metacriticLink
                val storeID = _state.value.storeID
                val gameID = _state.value.gameID
                var lastPrice = _state.value.lastPrice
                val salePrice = _state.value.salePrice
                val normalPrice = _state.value.normalPrice
                val isOnSale = _state.value.isOnSale
                val savings = _state.value.savings
                val metacriticScore = _state.value.metacriticScore
                val steamRatingText = _state.value.steamRatingText
                val steamRatingPercent = _state.value.steamRatingPercent
                val steamRatingCount = _state.value.steamRatingCount
                val steamAppID = _state.value.steamAppID
                val releaseDate = _state.value.releaseDate
                val lastChange = _state.value.lastChange
                val dealRating = _state.value.dealRating
                val thumb = _state.value.thumb

                val wish = wishlistGame(
                    dealID = dealID,
                    internalName = internalName,
                    title = title,
                    metacriticLink = metacriticLink,
                    storeID = storeID,
                    gameID = gameID,
                    lastPrice = lastPrice,
                    salePrice = salePrice,
                    normalPrice = normalPrice,
                    isOnSale = isOnSale,
                    savings = savings,
                    metacriticScore = metacriticScore,
                    steamRatingText = steamRatingText,
                    steamRatingPercent = steamRatingPercent,
                    steamRatingCount = steamRatingCount,
                    steamAppID = steamAppID,
                    releaseDate = releaseDate,
                    lastChange = lastChange,
                    dealRating = dealRating,
                    thumb = thumb
                )
                dao.insertWish(wish)
                _state.update {it.copy(
                    dealID = 0,
                    internalName  = "",
                     title = "",
                     metacriticLink = "",
                     storeID = "",
                     gameID = "",
                     lastPrice = 0.0f,
                     salePrice  = 0.0f,
                     normalPrice  = "",
                     isOnSale  = "",
                     savings  = "",
                     metacriticScore  = "",
                     steamRatingText  = "",
                     steamRatingPercent = "",
                     steamRatingCount  = "",
                     steamAppID  = "",
                     releaseDate  = 0L,
                     lastChange  = 0L,
                     dealRating  = "",
                     thumb  = "",
                     isAddingWish = false
                )
                }

            }

            is WishEvent.SetDealID -> {
                _state.update {it.copy(
                    dealID =  event.dealID
                )  }
            }
            is WishEvent.SetDealRating -> {
                _state.update { it.copy(
                    dealRating = event.dealRating
                ) }
            }
            is WishEvent.SetGameID -> {
                _state.update { it.copy(
                    gameID = event.gameID
                ) }
            }
            is WishEvent.SetInternalName -> {
                _state.update { it.copy(
                    internalName = event.internalName
                ) }
            }
            is WishEvent.SetIsOnSale -> {
                _state.update { it.copy(
                    isOnSale = event.isOnSale
                ) }
            }
            is WishEvent.SetLastChange -> {
                _state.update { it.copy(
                    lastChange = event.lastChange
                ) }
            }
            is WishEvent.SetLastPrice -> {
                _state.update { it.copy(
                    lastPrice = event.lastPrice
                ) }
            }
            is WishEvent.SetMetacriticLink -> {
                _state.update { it.copy(
                    metacriticLink = event.metacriticLink
                ) }
            }
            is WishEvent.SetMetacriticScore -> {
                _state.update { it.copy(
                    metacriticScore = event.metacriticScore
                ) }
            }
            is WishEvent.SetNormalPrice -> {
                _state.update { it.copy(
                    normalPrice = event.normalPrice
                ) }
            }
            is WishEvent.SetReleaseDate -> {
                _state.update { it.copy(
                    releaseDate = event.releaseDate
                ) }
            }
            is WishEvent.SetSalePrice -> {
                _state.update { it.copy(
                    salePrice = event.salePrice
                ) }
            }
            is WishEvent.SetSavings -> {
                _state.update { it.copy(
                    savings = event.savings
                ) }
            }
            is WishEvent.SetSteamAppID -> {
                _state.update { it.copy(
                    steamAppID = event.steamAppID
                ) }
            }
            is WishEvent.SetSteamRatingCount -> {
                _state.update { it.copy(
                    steamRatingCount = event.steamRatingCount
                ) }
            }
            is WishEvent.SetSteamRatingPercent -> {
                _state.update { it.copy(
                    steamRatingPercent = event.steamRatingPercent
                ) }
            }
            is WishEvent.SetSteamRatingText -> {
                _state.update { it.copy(
                    steamRatingText = event.steamRatingText
                ) }
            }
            is WishEvent.SetStoreID -> {
                _state.update { it.copy(
                    storeID = event.storeID
                ) }
            }
            is WishEvent.SetThumb -> {
                _state.update { it.copy(
                    thumb = event.thumb
                ) }
            }
            is WishEvent.SetTitle -> {
                _state.update { it.copy(
                    title = event.title
                ) }
            }

            is WishEvent.DeleteWish -> {
                dao.deleteWish(event.wish)
            }
            }
        }
    }
