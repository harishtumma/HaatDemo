package com.example.haat.data.reposiotry

import com.example.haat.data.local.dao.CartDAO
import com.example.haat.data.local.entity.CartItem
import com.example.haat.domain.data.VenuInfoData
import com.example.haat.domain.repository.CartRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor (val cartDAO: CartDAO) : CartRepository {
    private suspend  fun getCartItem() =cartDAO.getCartItems().first()

    override suspend fun getCartList(): List<VenuInfoData> {
       return getCartItem().map { it-> VenuInfoData(id= it.id,it.name, it.type, it.bannerImage,it.workingHour) }
    }

    override suspend fun addCart(venuInfoData: VenuInfoData) {
        cartDAO.addCartItem(CartItem(name = venuInfoData.name, type = venuInfoData.type, bannerImage = venuInfoData.bannerImage, workingHour = venuInfoData.workingHour))
    }
}