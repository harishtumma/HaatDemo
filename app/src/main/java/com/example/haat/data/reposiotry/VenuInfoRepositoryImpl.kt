package com.example.haat.data.reposiotry

import com.example.haat.domain.data.VenuInfoData
import com.example.haat.domain.repository.VenuInfoRepository
import com.example.haat.network.apiservice.BuisnessService
import javax.inject.Inject

class VenuInfoRepositoryImpl @Inject constructor(val buisnessService: BuisnessService): VenuInfoRepository {
    override suspend fun getVenuInfo(): VenuInfoData {
        val res=buisnessService.getVenuInfo()
       return VenuInfoData(name = res.name?.en_US?:"",
           type = res.type.toString(),
           bannerImage = res.bannerImages.get(0)?.serverImageUrl?:"",
           workingHour = res.workingHours?.currentWorkingHour?.toHour.toString()
           )
    }
}