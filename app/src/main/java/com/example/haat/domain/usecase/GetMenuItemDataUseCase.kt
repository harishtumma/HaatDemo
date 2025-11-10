package com.example.haat.domain.usecase

import android.util.Log
import com.example.haat.domain.data.ErrorData
import com.example.haat.domain.data.HomeData
import com.example.haat.domain.data.VenuInfoData
import com.example.haat.domain.repository.HomeRepository
import com.example.haat.domain.repository.VenuInfoRepository
import com.example.haat.domain.repository.VenuMenuRepository
import com.example.haat.domain.utility.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMenuItemDataUseCase @Inject constructor(val venuInfoRepository: VenuMenuRepository){
    operator fun invoke()= flow {
        emit(Resource.Loading)
        try {
            val homeData=venuInfoRepository.getVenuMenu()
            Log.d("hhh","getVenuMenu():${homeData}")
            val a=Resource.Success<List<VenuInfoData>>(homeData)
            emit(a)
        }catch (e: Exception)
        {
            emit(Resource.Error(ErrorData(e.message.toString())))
        }
    }
}