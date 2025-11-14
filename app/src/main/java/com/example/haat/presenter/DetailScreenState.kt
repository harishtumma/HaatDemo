package com.example.haat.presenter

import com.example.haat.domain.data.VenuInfoData

data class DetailScreenState (val isLoading: Boolean =false,
                              val error: String?=null,
                              val venuInfoData:  VenuInfoData? = null,
                              val venuInfoList:List<VenuInfoData> = arrayListOf(),
                              val venuInfo: VenuInfoData? = null,
                               val selectedItemForCart: VenuInfoData?=null)