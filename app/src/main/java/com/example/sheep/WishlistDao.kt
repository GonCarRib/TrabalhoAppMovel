package com.example.sheep


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WishlistDao{
    @Insert
    fun insertWishlist(wishlist:WishlistGame)

    @Query("DELETE FROM WishlistGame WHERE dealID = :Id")
    fun deleteWish(Id: Int)

    @Query("SELECT * FROM WishlistGame")
    fun getAllWishlist(): LiveData<List<WishlistGame>>

}