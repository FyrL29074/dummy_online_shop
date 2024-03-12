package com.fyrl29074.productslist.data.mapper

import com.fyrl29074.network.model.ProductDto
import com.fyrl29074.productslist.domain.model.Product

class ProductMapper {
    fun map(dto: ProductDto): Product {
        return Product(
            id = dto.id,
            title = dto.title,
            description = dto.description,
            thumbnail = dto.thumbnail,
            price = dto.price,
            rating = dto.rating
        )
    }
}