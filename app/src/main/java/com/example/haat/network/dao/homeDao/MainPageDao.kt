package com.example.haat.network.dao.homeDao
import com.google.gson.annotations.SerializedName


data class MainPageDao (

  @SerializedName("isInOperating"              ) var isInOperating              : Boolean?              = null,
  @SerializedName("showAccessibilityStatement" ) var showAccessibilityStatement : Boolean?              = null,
  @SerializedName("areaId"                     ) var areaId                     : Int?                  = null,
  @SerializedName("areaName"                   ) var areaName                   : String?               = null,
  @SerializedName("areaNameInEnglish"          ) var areaNameInEnglish          : String?               = null,
  @SerializedName("closestArea"                ) var closestArea                : String?               = null,
  @SerializedName("mainPageBanners"            ) var mainPageBanners            : MainPageBanners?      = MainPageBanners(),
  @SerializedName("categories"                 ) var categories                 : ArrayList<Categories> = arrayListOf(),
  @SerializedName("userSettings"               ) var userSettings               : UserSettings?         = UserSettings()

)