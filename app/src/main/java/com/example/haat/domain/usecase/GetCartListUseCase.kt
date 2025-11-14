package com.example.haat.domain.usecase

import com.example.haat.domain.data.ErrorData
import com.example.haat.domain.repository.CartRepository
import com.example.haat.domain.utility.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCartListUseCase @Inject constructor(val cartRepository: CartRepository){
    operator fun invoke()= flow {
        emit(Resource.Loading)
        try {
            emit(Resource.Success(cartRepository.getCartList()))
        }catch (e: Exception)
        {
            emit(Resource.Error(ErrorData(e.message.toString())))
        }
    }
}