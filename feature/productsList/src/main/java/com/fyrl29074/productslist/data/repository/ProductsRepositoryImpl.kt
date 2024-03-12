package com.fyrl29074.productslist.data.repository

import com.fyrl29074.network.dataSources.ProductsDataSource
import com.fyrl29074.productslist.data.mapper.ProductMapper
import com.fyrl29074.productslist.domain.model.Product
import com.fyrl29074.productslist.domain.repository.ProductsRepository

class ProductsRepositoryImpl(
    private val productsDataSource: ProductsDataSource,
    private val productMapper: ProductMapper,
) : ProductsRepository {
    override suspend fun getProductsByPage(page: Int): List<Product> {
        val products = productsDataSource
            .getProductsBy(page)
            .map { dto ->
                productMapper.map(dto)
            }

        return products
    }
}