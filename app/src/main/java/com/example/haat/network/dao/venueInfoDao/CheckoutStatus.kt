package com.example.haat.network.dao.venueInfoDao
import com.google.gson.annotations.SerializedName


data class CheckoutStatus (

  @SerializedName("enabled"     ) var enabled     : Boolean? = null,
  @SerializedName("buttonTitle" ) var buttonTitle : String?  = null

)