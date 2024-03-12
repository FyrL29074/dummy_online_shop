package com.fyrl29074.productslist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fyrl29074.productslist.domain.useCase.GetProductsByPageUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductsListViewModel(
    private val getProductsByPageUseCase: GetProductsByPageUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow<State>(State.Waiting)
    val state = _state.asStateFlow()

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