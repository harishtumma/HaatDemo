package com.example.haat.network.dao.homeDao
import com.google.gson.annotations.SerializedName


data class BackgroundImage (

  @SerializedName("serverImage"      ) var serverImage      : String? = null,
  @SerializedName("smallServerImage" ) var smallServerImage : String? = null,
  @SerializedName("blurhashImage"    ) var blurhashImage    : String? = null

)