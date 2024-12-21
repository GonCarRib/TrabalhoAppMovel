package com.example.sheep

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(application: Application) : ViewModel() {
    var selectedGameDeal: GameDeal? = null
    val allWishlists: LiveData<List<WishlistGame>>
    private val repository: WishlistRepository
    val searchResults: MutableLiveData<List<WishlistGame>>

    init {
        val wishlistDb = WishlistRoomDatabase.getInstance(application)
        val wishlistDao = wishlistDb.wishlistDao()
        repository = WishlistRepository(wishlistDao)

        allWishlists = repository.allWishlists
        searchResults = repository.searchResults
    }
    fun insertWishlist(wishlist: WishlistGame) {
        repository.insertWishlist(wishlist)
    }
    fun deleteWishlist(Id: String) {
        repository.deleteWishlist(Id)
    }
}