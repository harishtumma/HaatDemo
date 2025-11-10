package com.example.haat.presenter

import com.example.haat.domain.data.HomeData

data class HomeScreenState (val isLoading: Boolean =false,
    val error: String?=null,
    val homeData:  HomeData? = null,
    )