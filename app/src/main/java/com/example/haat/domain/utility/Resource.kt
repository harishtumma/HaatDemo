package com.example.haat.domain.utility

import com.example.haat.domain.data.ErrorData

sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val error: ErrorData) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}