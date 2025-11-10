package com.example.haat.network.dao.homeDao
import com.google.gson.annotations.SerializedName


data class Banners (

  @SerializedName("businessId"   ) var businessId   : Int?          = null,
  @SerializedName("businessName" ) var businessName : BusinessName? = BusinessName(),
  @SerializedName("businessType" ) var businessType : String?       = null,
  @SerializedName("linkedBanner" ) var linkedBanner : Boolean?      = null,
  @SerializedName("image"        ) var image        : Image?        = Image()

)