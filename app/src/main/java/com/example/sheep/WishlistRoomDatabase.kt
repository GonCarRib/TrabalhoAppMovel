package com.example.sheep


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [(WishlistGame::class)], version = 1, exportSchema = false)
abstract class WishlistRoomDatabase: RoomDatabase() {
    abstract fun wishlistDao(): WishlistDao
    companion object {
        private var INSTANCE: WishlistRoomDatabase? = null
        fun getInstance(context: Context): WishlistRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        WishlistRoomDatabase::class.java,
                        "Wishlist_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}