package com.example.haat.data.reposiotry

import com.example.haat.domain.data.HomeData
import com.example.haat.domain.repository.HomeRepository
import com.example.haat.network.apiservice.BuisnessService
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(val buisnessService: BuisnessService): HomeRepository {
    override suspend fun getHomeData(): HomeData {
        val res=buisnessService.getMainPage()
       return HomeData(banners = res.mainPageBanners!!.banners,
           categories = res.categories)
    }
}