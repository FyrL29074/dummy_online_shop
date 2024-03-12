package com.fyrl29074.productslist.domain.model

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val thumbnail: String,
    val price: Int,
    val rating: Double
)
