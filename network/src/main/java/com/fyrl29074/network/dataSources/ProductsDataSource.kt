package com.fyrl29074.network.dataSources

import com.fyrl29074.network.api.ProductsApi
import com.fyrl29074.network.model.ProductDto
import java.net.UnknownHostException

class ProductsDataSource(
    private val productsApi: ProductsApi
) {

    suspend fun getProductsBy(page: Int): List<ProductDto> {
        val skip = page * PRODUCTS_LIMIT
        try {
            val response = productsApi.getProductsBy(
                skip = skip,
                limit = PRODUCTS_LIMIT,
            )
            return response.products
        } catch (_: UnknownHostException) {
            throw UnknownHostException(NO_INTERNET_CONNECTION_MESSAGE)
        }
    }


    companion object {
        const val PRODUCTS_LIMIT = 20
        const val NO_INTERNET_CONNECTION_MESSAGE =
            "No internet connection. Please check your network settings."
    }
}