package com.example.haat.domain.usecase

import com.example.haat.domain.data.ErrorData
import com.example.haat.domain.data.HomeData
import com.example.haat.domain.repository.HomeRepository
import com.example.haat.domain.utility.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetHomeDataUseCase @Inject constructor(val homeRepository: HomeRepository){
    operator fun invoke()= flow {
        emit(Resource.Loading)
        try {
            val homeData=homeRepository.getHomeData()
            val a=Resource.Success<HomeData>(homeData)
            emit(a)
        }catch (e: Exception)
        {
            emit(Resource.Error(ErrorData(e.message.toString())))
        }
    }
}