package com.example.sheep

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class WishlistRepository(private val wishlistDao: WishlistDao) {
    val allWishlists: LiveData<List<WishlistGame>> = wishlistDao.getAllWishlist()
    val searchResults = MutableLiveData<List<WishlistGame>>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insertWishlist(newwishlist: WishlistGame) {
        coroutineScope.launch(Dispatchers.IO) {
            wishlistDao.insertWishlist(newwishlist)
        }
    }
    fun deleteWishlist(Id: String) {
        coroutineScope.launch(Dispatchers.IO) {
            wishlistDao.deleteWish(Id)
        }
    }

}