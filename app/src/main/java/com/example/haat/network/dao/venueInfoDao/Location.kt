package com.example.haat.network.dao.venueInfoDao
import com.google.gson.annotations.SerializedName


data class Location (

  @SerializedName("areaId"    ) var areaId    : Int?    = null,
  @SerializedName("address"   ) var address   : String? = null,
  @SerializedName("longitude" ) var longitude : Double? = null,
  @SerializedName("latitude"  ) var latitude  : Double? = null

)