package com.example.haat.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.haat.domain.data.HomeData
import com.example.haat.domain.usecase.GetHomeDataUseCase
import com.example.haat.domain.utility.Resource
import com.example.haat.presenter.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


@HiltViewModel
class HomeViewmodel @Inject constructor(val useCase: GetHomeDataUseCase) : ViewModel() {
    private val _homeScreenState = MutableStateFlow(HomeScreenState())
    val homeScreenState = _homeScreenState.asStateFlow()


    fun loadHomeData() {
        viewModelScope.launch {
            useCase.invoke().collect { resource ->
                when (resource) {
                    is Resource.Error -> {
                        Log.d("hhh", resource.error.message)
                        _homeScreenState.update {
                            it.copy(isLoading = false)
                        }

                    }

                    is Resource.Loading -> _homeScreenState.update {
                        it.copy(isLoading = true)
                    }

                    is Resource.Success<*> -> {

                        _homeScreenState.update {
                            it.copy(isLoading = false, homeData = (resource.data as HomeData))
                        }
                        Log.d("hhh",resource.data.toString())
                    }
                }

            }
        }
    }
}