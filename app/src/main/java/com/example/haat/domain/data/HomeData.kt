package com.example.haat.domain.data

import com.example.haat.network.dao.homeDao.Banners
import com.example.haat.network.dao.homeDao.Categories
import com.google.gson.annotations.SerializedName

data class HomeData(
    var banners: ArrayList<Banners> = arrayListOf(),
    var categories: ArrayList<Categories> = arrayListOf()
)
