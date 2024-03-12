package com.fyrl29074.network.dataSources

import com.fyrl29074.network.api.ProductsApi
import com.fyrl29074.network.model.ProductDto

class ProductsDataSource(
    private val productsApi: ProductsApi
) {

    suspend fun getProductsBy(page: Int): List<ProductDto> {
        val skip = (page - 1) * PRODUCTS_LIMIT
        val response = productsApi.getProductsBy(
            skip = skip,
            limit = PRODUCTS_LIMIT,
        )

        // TODO: handle errors (network, server, etc.)

        return response.products
    }


    companion object {
        const val PRODUCTS_LIMIT = 20
    }
}