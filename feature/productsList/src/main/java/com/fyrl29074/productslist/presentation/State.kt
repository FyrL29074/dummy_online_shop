package com.fyrl29074.productslist.presentation

import com.fyrl29074.productslist.domain.model.Product

sealed class State {
    data object Waiting : State()
    data object Loading : State()
    data class Loaded(val data: List<Product>) : State()
    data class Error(val message: String) : State()
}