package com.devanand.revestapp.api

import com.devanand.revestapp.ApiConstants
import com.devanand.revestapp.models.MyProducts
import retrofit2.http.GET

interface ProductApi {

    @GET(ApiConstants.END_POINT)
    suspend fun getProducts() : MyProducts
}