package com.example.haat.network.dao.venueInfoDao
import com.google.gson.annotations.SerializedName


data class WorkingHours (

  @SerializedName("isOpened24Hours"    ) var isOpened24Hours    : Boolean?                = null,
  @SerializedName("isClosed24Hours"    ) var isClosed24Hours    : Boolean?                = null,
  @SerializedName("currentWorkingHour" ) var currentWorkingHour : CurrentWorkingHour?     = CurrentWorkingHour(),
  @SerializedName("workingHours"       ) var workingHours       : ArrayList<WorkingHours> = arrayListOf()

)