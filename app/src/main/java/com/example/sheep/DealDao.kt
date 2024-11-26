package com.example.sheep

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DealDao {
    @Insert
    fun insertDeal(deal: GameDeal)

    @Delete
    fun deleteDeal(deal: GameDeal)

   @Query("SELECT * FROM GameDeal ORDER BY dealID ASC")
    fun getDealsById(): Flow<List<GameDeal>>
}