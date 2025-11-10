package com.example.haat.network.dao.venueInfoDao
import com.google.gson.annotations.SerializedName


data class Status (

  @SerializedName("status"             ) var status             : Int?     = null,
  @SerializedName("closestWorkingHour" ) var closestWorkingHour : String?  = null,
  @SerializedName("is24Hours"          ) var is24Hours          : Boolean? = null

)