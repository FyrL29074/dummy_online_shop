package com.fyrl29074.productslist.presentation.recyclerView

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.fyrl29074.productslist.domain.model.Product
import com.fyrl29074.productslist.domain.useCase.GetProductsByPageUseCase

class ProductsPagingSource(
    private val getProductsByPageUseCase: GetProductsByPageUseCase
) : PagingSource<Int, Product>() {
    override fun getRefreshKey(state: PagingState<Int, Product>): Int = FIRST_PAGE

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        val page = params.key ?: FIRST_PAGE
        return runCatching {
            getProductsByPageUseCase.execute(page)
        }.fold(
            onSuccess = { products ->
                LoadResult.Page(
                    data = products,
                    prevKey = null,
                    nextKey = if (products.isEmpty()) null else page + 1,
                )
            },
            onFailure = { e ->
                LoadResult.Error(e)
            }
        )
    }

    companion object {
        private const val FIRST_PAGE = 0
    }
}