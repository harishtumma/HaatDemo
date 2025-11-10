package com.example.haat.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.haat.domain.data.VenuInfoData
import com.example.haat.domain.usecase.GetMenuInfoDataUseCase
import com.example.haat.domain.usecase.GetMenuItemDataUseCase
import com.example.haat.domain.utility.Resource
import com.example.haat.presenter.DetailScreenState
import com.example.haat.presenter.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsPageViewModel @Inject constructor(val getMenuInfoDataUseCase: GetMenuInfoDataUseCase, val getMenuItemDataUseCase: GetMenuItemDataUseCase): ViewModel()
{
    val detailsPageUiState_ = MutableStateFlow(DetailScreenState())
    val detailsPageUiState = detailsPageUiState_.asStateFlow()

    fun loadDetailsPage()
    {
        viewModelScope.launch {
            loadVenuInfoData()
            loadVenuMenuData()
        }
    }

    fun loadVenuInfoData(){
        viewModelScope.launch {
            getMenuInfoDataUseCase().collect {resource ->

                when(resource)
                {
                    is Resource.Error ->{ detailsPageUiState_.update { it.copy(isLoading = false ,
                        error = resource.error.message) } }
                    Resource.Loading -> detailsPageUiState_.update { it.copy(isLoading = true) }
                    is Resource.Success<*> ->{
                        detailsPageUiState_.update { it.copy(isLoading = false , venuInfoData = resource.data as VenuInfoData) }
                    }
                }
            }
        }
    }

    fun loadVenuMenuData(){
        viewModelScope.launch {
            getMenuItemDataUseCase().collect {resource ->

                when(resource)
                {
                    is Resource.Error ->{
                        Log.d("hhh","menu Itme${resource.error}")
                        detailsPageUiState_.update { it.copy(isLoading = false ,
                        error = resource.error.message) } }
                    Resource.Loading -> detailsPageUiState_.update { it.copy(isLoading = true) }
                    is Resource.Success<*> ->{

                        Log.d("hhh","menu Itme${resource.data}")
                        detailsPageUiState_.update { it.copy(isLoading = false , venuInfoList = resource.data as List<VenuInfoData>) }
                    }
                }
            }
        }
    }

}