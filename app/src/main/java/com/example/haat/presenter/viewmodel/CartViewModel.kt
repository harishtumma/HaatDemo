package com.example.haat.presenter.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.haat.data.local.entity.CartItem
import com.example.haat.domain.data.VenuInfoData
import com.example.haat.domain.repository.CartRepository
import com.example.haat.domain.usecase.AddCartUseCase
import com.example.haat.domain.usecase.GetCartListUseCase
import com.example.haat.domain.utility.Resource
import com.example.haat.presenter.CartScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(val getCartListUseCase: GetCartListUseCase) : ViewModel() {
    private val _cartScreenState = MutableStateFlow<CartScreenState>(CartScreenState())
    val cartScreenState = _cartScreenState.asStateFlow()


     fun loadCartList() {
        viewModelScope.launch {
            getCartListUseCase().collect {data->
                when(data){
                    is Resource.Error ->{

                    }
                    Resource.Loading -> {   _cartScreenState.update {
                        it.copy(isLoading = true)
                    } }
                    is Resource.Success<*> -> {
                        Log.d("hhh","getCartListUseCase() : ${data.data}")

                       var list = ( data.data as List<VenuInfoData>).map { venu->
                            com.example.haat.presenter.CartItem(venu.id,venu.name,1.0,1)
                        }
                        _cartScreenState.update {

                            it.copy(isLoading = false, carlList =list )
                        }
                    }
                }
            }

        }
//            _cartScreenState.update {
//                it.copy(
//                    isLoading = true
//                )
//            }
//
//            _cartScreenState.update {
//                it.copy(
//                    isLoading = false,
//                    carlList = cartRepository.getCartList().map {
//                        it
//                        com.example.haat.presenter.CartItem(
//                            id = it.id,
//                            name = it.name, price = 1.0, quantity = 1
//                        )
//                    }
//
//                )
//            }
//        }
    }

   /* fun removeItem(itemId: Int) {
        _cartItems.removeAll { it.id == itemId }
    }*/
}
