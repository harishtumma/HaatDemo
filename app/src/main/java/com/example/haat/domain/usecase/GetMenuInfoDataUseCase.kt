package com.example.haat.domain.usecase

import com.example.haat.domain.data.ErrorData
import com.example.haat.domain.data.HomeData
import com.example.haat.domain.data.VenuInfoData
import com.example.haat.domain.repository.HomeRepository
import com.example.haat.domain.repository.VenuInfoRepository
import com.example.haat.domain.utility.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMenuInfoDataUseCase @Inject constructor(val venuInfoRepository: VenuInfoRepository){
    operator fun invoke()= flow {
        emit(Resource.Loading)
        try {
            val homeData=venuInfoRepository.getVenuInfo()
            val a=Resource.Success<VenuInfoData>(homeData)
            emit(a)
        }catch (e: Exception)
        {
            emit(Resource.Error(ErrorData(e.message.toString())))
        }
    }
}