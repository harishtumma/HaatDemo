package com.example.haat.network.dao.venueInfoDao
import com.google.gson.annotations.SerializedName


data class ShareData (

  @SerializedName("message" ) var message : String? = null,
  @SerializedName("url"     ) var url     : String? = null

)