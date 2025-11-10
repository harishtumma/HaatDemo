package com.example.haat.network.dao.venueInfoDao
import com.google.gson.annotations.SerializedName


data class Currency (

  @SerializedName("symbol" ) var symbol : String? = null,
  @SerializedName("name"   ) var name   : String? = null

)