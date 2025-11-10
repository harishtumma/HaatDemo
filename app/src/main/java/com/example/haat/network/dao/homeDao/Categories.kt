package com.example.haat.network.dao.homeDao
import com.google.gson.annotations.SerializedName


data class Categories (

  @SerializedName("id"              ) var id              : Int?              = null,
  @SerializedName("priority"        ) var priority        : Int?              = null,
  @SerializedName("elementType"     ) var elementType     : String?           = null,
  @SerializedName("isPopular"       ) var isPopular       : Boolean?          = null,
  @SerializedName("name"            ) var name            : String?           = null,
  @SerializedName("backgroundImage" ) var backgroundImage : BackgroundImage?  = BackgroundImage(),
  @SerializedName("topImage"        ) var topImage        : TopImage?         = TopImage(),
  @SerializedName("topImageType"    ) var topImageType    : Int?              = null,
  @SerializedName("isSponsored"     ) var isSponsored     : Boolean?          = null,
  @SerializedName("viewAll"         ) var viewAll         : Boolean?          = null,
  @SerializedName("backgroundColor" ) var backgroundColor : String?           = null,
  @SerializedName("stores"          ) var stores          : ArrayList<Stores> = arrayListOf()

)