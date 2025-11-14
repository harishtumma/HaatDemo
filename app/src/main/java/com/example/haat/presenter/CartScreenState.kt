package com.example.haat.presenter


data class CartScreenState (val isLoading: Boolean =false,
                            val error: String?=null,
                            val carlList: List<com.example.haat.presenter.CartItem> = arrayListOf() )