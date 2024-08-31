package com.devanand.revestapp.models

data class Products(
    var id: Int? = null,
    var title: String? = null,
    var description: String? = null,
    var category: String? = null,
    var price: Double? = null,
    var discountPercentage: Double? = null,
    var rating: Double? = null,
    var stock: Int? = null,
    var tags: ArrayList<String> = arrayListOf(),
    var brand: String? = null,
    var sku: String? = null,
    var weight: Int? = null,
    var dimensions: Dimensions? = Dimensions(),
    var warrantyInformation: String? = null,
    var shippingInformation: String? = null,
    var availabilityStatus: String? = null,
    var reviews: ArrayList<Reviews> = arrayListOf(),
    var returnPolicy: String? = null,
    var minimumOrderQuantity: Int? = null,
    var meta: Meta? = Meta(),
    var images: ArrayList<String> = arrayListOf(),
    var thumbnail: String? = null
)
