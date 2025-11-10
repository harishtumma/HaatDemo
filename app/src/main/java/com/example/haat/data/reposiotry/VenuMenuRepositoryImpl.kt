package com.example.haat.data.reposiotry

import MenuDao
import android.util.Log
import com.example.haat.domain.data.VenuInfoData
import com.example.haat.domain.repository.VenuInfoRepository
import com.example.haat.domain.repository.VenuMenuRepository
import com.example.haat.network.apiservice.BuisnessService
import java.time.temporal.ValueRange
import javax.inject.Inject

class VenuMenuRepositoryImpl @Inject constructor(val buisnessService: BuisnessService): VenuMenuRepository {

    override suspend fun getVenuMenu(): List<VenuInfoData> {
        val res=buisnessService.getMenu().sections
        Log.d("hhh","VenuMenuRepositoryImpl res :$res")
        val list =res.map {it->
            VenuInfoData (name =it.name?:"",
                type=it.type?:"",
                bannerImage ="", //it.categories?.get(0)?.image?.serverImageUrl?:"",
                workingHour=""
                )
        }

        Log.d("hhh","VenuMenuRepositoryImpl res list:$list")
        return list
    }
}