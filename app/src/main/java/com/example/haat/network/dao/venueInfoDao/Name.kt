package com.example.haat.network.dao.venueInfoDao
import com.google.gson.annotations.SerializedName


data class Name (

  @SerializedName("ar"    ) var ar    : String? = null,
  @SerializedName("en-US" ) var en_US : String? = null,
  @SerializedName("he"    ) var he    : String? = null,
  @SerializedName("fr"    ) var fr    : String? = null

)