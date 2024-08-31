package com.devanand.revestapp.models

data class MyProducts(
     var products: ArrayList<Products> = arrayListOf(),
     var total: Int? = null,
     var skip: Int? = null,
     var limit: Int? = null
)
