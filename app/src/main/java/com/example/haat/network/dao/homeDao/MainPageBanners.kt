package com.example.haat.network.dao.homeDao
import com.google.gson.annotations.SerializedName


data class MainPageBanners (

  @SerializedName("interval" ) var interval : Int?               = null,
  @SerializedName("banners"  ) var banners  : ArrayList<Banners> = arrayListOf()

)