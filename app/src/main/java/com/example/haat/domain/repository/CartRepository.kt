package com.example.haat.domain.repository

import com.example.haat.domain.data.VenuInfoData

interface CartRepository {
    suspend fun getCartList():List<VenuInfoData>
    suspend fun addCart(venuInfoData: VenuInfoData)
}