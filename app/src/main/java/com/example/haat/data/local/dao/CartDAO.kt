package com.example.haat.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.haat.data.local.entity.CartItem
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDAO {
    @Query("SELECT * FROM cart_item")
    fun getCartItems(): Flow<List<CartItem>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCartItem(items: CartItem): Long
}