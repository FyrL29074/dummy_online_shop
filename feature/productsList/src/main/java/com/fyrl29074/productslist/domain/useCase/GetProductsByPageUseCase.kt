package com.fyrl29074.productslist.domain.useCase

import com.fyrl29074.productslist.domain.model.Product

interface GetProductsByPageUseCase {
    suspend fun execute(page: Int): List<Product>
}