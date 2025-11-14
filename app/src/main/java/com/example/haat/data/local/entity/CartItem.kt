package com.example.haat.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.haat.domain.data.HomeData

@Entity("cart_item")
data class CartItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val type:String,
    val bannerImage: String,
    val workingHour: String)

