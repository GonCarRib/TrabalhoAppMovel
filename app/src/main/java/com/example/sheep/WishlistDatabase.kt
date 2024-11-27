package com.example.sheep

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [wishlistGame::class],
    version = 1
)

abstract class wishlistDatabase : RoomDatabase() {

    abstract val dao: WishDao

}