package com.fyrl29074.productslist.domain.useCase

import com.fyrl29074.productslist.domain.model.Product
import com.fyrl29074.productslist.domain.repository.ProductsRepository

class GetProductsByPageUseCaseImpl(
    private val productsRepository: ProductsRepository
): GetProductsByPageUseCase {
    override suspend fun execute(page: Int): List<Product> {
        return productsRepository.getProductsByPage(page)
    }
}