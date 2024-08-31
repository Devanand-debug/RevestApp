package com.devanand.revestapp.models

data class Reviews(
    var rating        : Int?    = null,
    var comment       : String? = null,
    var date          : String? = null,
    var reviewerName  : String? = null,
    var reviewerEmail : String? = null
)
