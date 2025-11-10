package com.example.haat.domain.repository

import com.example.haat.domain.data.VenuInfoData
import com.example.haat.network.dao.venueInfoDao.VenuInfoDao

interface VenuInfoRepository {
    suspend fun getVenuInfo(): VenuInfoData
}

