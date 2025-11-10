package com.example.haat.network.dao.homeDao
import com.google.gson.annotations.SerializedName


data class Stores (

  @SerializedName("storeId"            ) var storeId            : Int?               = null,
  @SerializedName("franchiseId"        ) var franchiseId        : String?            = null,
  @SerializedName("name"               ) var name               : String?            = null,
  @SerializedName("address"            ) var address            : String?            = null,
  //@SerializedName("opacity"            ) var opacity            : Int?               = null,
  @SerializedName("distance"           ) var distance           : Double?            = null,
  @SerializedName("icon"               ) var icon               : Icon?              = Icon(),
  @SerializedName("rating"             ) var rating             : Rating?            = Rating(),
  @SerializedName("labels"             ) var labels             : ArrayList<String>  = arrayListOf(),
  @SerializedName("closestWorkingHour" ) var closestWorkingHour : String?            = null,
  @SerializedName("is24Hours"          ) var is24Hours          : Boolean?           = null,
  @SerializedName("priority"           ) var priority           : Int?               = null,
  @SerializedName("status"             ) var status             : Int?               = null,
  @SerializedName("isNew"              ) var isNew              : Boolean?           = null,
  @SerializedName("zoneId"             ) var zoneId             : String?            = null,
  @SerializedName("type"               ) var type               : String?            = null,
  @SerializedName("businessCardImage"  ) var businessCardImage  : BusinessCardImage? = BusinessCardImage(),
  @SerializedName("cardImageType"      ) var cardImageType      : String?            = null

)