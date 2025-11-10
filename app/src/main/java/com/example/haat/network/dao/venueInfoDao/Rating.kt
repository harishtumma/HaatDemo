package com.example.haat.network.dao.venueInfoDao
import com.google.gson.annotations.SerializedName


data class Rating (

  @SerializedName("ratings"         ) var ratings         : Int?     = null,
  @SerializedName("numberOfRatings" ) var numberOfRatings : String?  = null,
  @SerializedName("topRated"        ) var topRated        : Boolean? = null,
  @SerializedName("isNew"           ) var isNew           : Boolean? = null

)