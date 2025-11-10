package com.example.haat.network.dao.venueInfoDao
import com.google.gson.annotations.SerializedName


data class CurrentWorkingHour (

  @SerializedName("dayOfWeek" ) var dayOfWeek : Int?    = null,
  @SerializedName("fromHour"  ) var fromHour  : String? = null,
  @SerializedName("toHour"    ) var toHour    : String? = null,
  @SerializedName("type"      ) var type      : Int?    = null

)