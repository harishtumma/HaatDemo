package com.example.haat.domain.repository

import com.example.haat.domain.data.HomeData
import com.example.haat.domain.utility.Resource

interface HomeRepository {
    suspend fun getHomeData(): HomeData
}
