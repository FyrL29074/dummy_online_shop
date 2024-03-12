package com.fyrl29074.productslist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.fyrl29074.productslist.domain.model.Product
import com.fyrl29074.productslist.domain.useCase.GetProductsByPageUseCase
import com.fyrl29074.productslist.presentation.recyclerView.ProductsPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductsListViewModel(
    private val getProductsByPageUseCase: GetProductsByPageUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow<State>(State.Waiting)
    val state = _state.asStateFlow()

    val pagedProducts: Flow<PagingData<Product>> = Pager(
        config = PagingConfig(pageSize = 20),
        pagingSourceFactory = { ProductsPagingSource(getProductsByPageUseCase) }
    ).flow.cachedIn(viewModelScope)

    fun getProductsByPage(page: Int) {
        _state.value = State.Loading

        viewModelScope.launch {
            runCatching {
                getProductsByPageUseCase.execute(page)
            }.fold(
                onSuccess = { products ->
                    _state.value = State.Loaded(products)
                },
                onFailure = { e ->
                    _state.value = State.Error(e.message ?: "Unknown error occurred")
                }
            )
        }
    }
}