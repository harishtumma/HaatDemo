package com.example.haat.network.dao.homeDao
import com.google.gson.annotations.SerializedName


data class Rating (

  @SerializedName("value"           ) var value           : Double? = null,
  @SerializedName("numberOfRatings" ) var numberOfRatings : String? = null

)