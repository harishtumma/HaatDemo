package com.example.haat.network.dao.homeDao
import com.google.gson.annotations.SerializedName


data class BusinessCardImage (

  @SerializedName("serverImage"   ) var serverImage   : String? = null,
  @SerializedName("blurhashImage" ) var blurhashImage : String? = null

)