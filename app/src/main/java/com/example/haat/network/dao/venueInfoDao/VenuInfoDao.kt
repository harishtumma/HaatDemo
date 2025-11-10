package com.example.haat.network.dao.venueInfoDao
import com.google.gson.annotations.SerializedName


data class VenuInfoDao (

  @SerializedName("id"                           ) var id                           : Int?                    = null,
  @SerializedName("rating"                       ) var rating                       : Rating?                 = Rating(),
  @SerializedName("location"                     ) var location                     : Location?               = Location(),
  @SerializedName("isPreferredBusiness"          ) var isPreferredBusiness          : Boolean?                = null,
  @SerializedName("shouldShowRecentOrderToolTip" ) var shouldShowRecentOrderToolTip : Boolean?                = null,
  @SerializedName("phoneNumbers"                 ) var phoneNumbers                 : ArrayList<String>       = arrayListOf(),
  @SerializedName("workingHours"                 ) var workingHours                 : WorkingHours?           = WorkingHours(),
  @SerializedName("status"                       ) var status                       : Status?                 = Status(),
  @SerializedName("type"                         ) var type                         : String?                 = null,
  @SerializedName("name"                         ) var name                         : Name?                   = Name(),
  @SerializedName("noticeMessage"                ) var noticeMessage                : String?                 = null,
  @SerializedName("shareData"                    ) var shareData                    : ShareData?              = ShareData(),
  @SerializedName("iconImage"                    ) var iconImage                    : IconImage?              = IconImage(),
  @SerializedName("bannerImages"                 ) var bannerImages                 : ArrayList<BannerImages> = arrayListOf(),
  @SerializedName("banner"                       ) var banner                       : Banner?                 = Banner(),
  @SerializedName("currency"                     ) var currency                     : Currency?               = Currency(),
  @SerializedName("notes"                        ) var notes                        : ArrayList<String>       = arrayListOf(),
  @SerializedName("checkoutStatus"               ) var checkoutStatus               : CheckoutStatus?         = CheckoutStatus(),
  @SerializedName("labels"                       ) var labels                       : ArrayList<String>       = arrayListOf(),
  @SerializedName("franchiseBranches"            ) var franchiseBranches            : String?                 = null

)