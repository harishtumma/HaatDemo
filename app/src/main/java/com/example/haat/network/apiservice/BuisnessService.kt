package com.example.haat.network.apiservice

import MenuDao
import com.example.haat.network.dao.homeDao.MainPageDao
import com.example.haat.network.dao.venueInfoDao.VenuInfoDao
import retrofit2.http.GET
import retrofit2.http.Headers

interface BuisnessService {

    @Headers("Accept-Language:en-US")
    @GET("/api/user/main-page/by-area/1?type=Market&userId=e1fb17e0-25e6-4809-ae71-ce3fbf6505ba")
    suspend fun getMainPage(): MainPageDao

    @Headers("Accept-Language:en-US")
    @GET("api/venue/4012/info?userLatitude=0.0&userLongitude=0.0&isByLocation=false")
    suspend fun getVenuInfo(): VenuInfoDao


    @Headers("Accept-Language:en-US")
    @GET("api/venue/4012/menu")
    suspend fun getMenu(): MenuDao



}