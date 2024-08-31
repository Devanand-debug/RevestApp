package com.devanand.revestapp.repository

import com.devanand.revestapp.api.ProductApi
import com.devanand.revestapp.models.MyProducts
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productApi: ProductApi) {

    suspend fun getProductsRepo() : MyProducts {
        return productApi.getProducts()
    }
}