package com.example.haat.network.dao.homeDao
import com.google.gson.annotations.SerializedName


data class UserSettings (

  @SerializedName("offersPromotionsConsent" ) var offersPromotionsConsent : Boolean? = null

)