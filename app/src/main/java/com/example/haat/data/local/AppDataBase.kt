package com.example.haat.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.haat.data.local.dao.CartDAO
import com.example.haat.data.local.entity.CartItem

@Database(entities = [CartItem::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun cartDao(): CartDAO
}