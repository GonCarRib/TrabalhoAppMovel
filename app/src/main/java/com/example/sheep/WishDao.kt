package com.example.sheep

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WishDao {

    @Insert
    fun insertWish(wish: wishlistGame)

    @Delete
    fun deleteWish(wish: wishlistGame)

   @Query("SELECT * FROM wishlistGame ")
    fun getWishs(): Flow<List<GameDeal>>
}