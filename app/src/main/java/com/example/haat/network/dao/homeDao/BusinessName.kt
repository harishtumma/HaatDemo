package com.example.haat.network.dao.homeDao
import com.google.gson.annotations.SerializedName


data class BusinessName (

  @SerializedName("ar"    ) var ar    : String? = null,
  @SerializedName("en-US" ) var en_US : String? = null,
  @SerializedName("he"    ) var he    : String? = null,
  @SerializedName("fr"    ) var fr    : String? = null

)