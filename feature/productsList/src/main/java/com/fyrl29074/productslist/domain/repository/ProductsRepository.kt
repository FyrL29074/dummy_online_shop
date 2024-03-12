package com.fyrl29074.productslist.domain.repository

import com.fyrl29074.productslist.domain.model.Product

interface ProductsRepository {
    suspend fun getProductsByPage(page: Int): List<Product>
}