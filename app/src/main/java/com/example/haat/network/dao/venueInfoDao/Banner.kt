package com.example.haat.network.dao.venueInfoDao
import com.google.gson.annotations.SerializedName


data class Banner (

  @SerializedName("timer"  ) var timer  : Int?              = null,
  @SerializedName("images" ) var images : ArrayList<Images> = arrayListOf()

)