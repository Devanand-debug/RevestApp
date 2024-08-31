package com.devanand.revestapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devanand.revestapp.repository.ProductRepository
import com.devanand.revestapp.models.MyProducts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repository: ProductRepository) : ViewModel(){

    private val _productData = mutableStateOf<MyProducts?>(null)
    val productData : State<MyProducts?> = _productData

    var isLoading = mutableStateOf(true)
        private set

//    init {
//        viewModelScope.launch {
//            val data = repository.getProductsRepo()
//            _productData.value = data
//            //_productData.value = repository.getProductsRepo()
//        }
//    }

    fun fetchData(){
        viewModelScope.launch {
            try{
                isLoading.value = true
                val data = repository.getProductsRepo()
                _productData.value = data
            }finally {
                isLoading.value = false
            }

        }
    }

}