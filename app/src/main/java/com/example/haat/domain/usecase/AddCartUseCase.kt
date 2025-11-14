package com.example.haat.domain.usecase

import com.example.haat.domain.data.ErrorData
import com.example.haat.domain.data.HomeData
import com.example.haat.domain.data.VenuInfoData
import com.example.haat.domain.repository.CartRepository
import com.example.haat.domain.repository.HomeRepository
import com.example.haat.domain.utility.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddCartUseCase @Inject constructor(val cartRepository: CartRepository){
    operator fun invoke(venuInfoData: VenuInfoData)= flow {
        emit(Resource.Loading)
        try {
            emit(Resource.Success(cartRepository.addCart(venuInfoData = venuInfoData)))
        }catch (e: Exception)
        {
            emit(Resource.Error(ErrorData(e.message.toString())))
        }
    }
}