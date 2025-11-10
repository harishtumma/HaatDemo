package com.example.haat.domain.repository

import MenuDao
import com.example.haat.domain.data.VenuInfoData
import com.example.haat.network.dao.venueInfoDao.VenuInfoDao

interface VenuMenuRepository {
    suspend fun getVenuMenu(): List<VenuInfoData>
}

