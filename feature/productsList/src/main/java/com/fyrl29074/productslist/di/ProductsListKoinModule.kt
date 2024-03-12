package com.fyrl29074.productslist.di

import com.fyrl29074.productslist.data.repository.ProductsRepositoryImpl
import com.fyrl29074.productslist.presentation.ProductsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.dsl.bind
import com.fyrl29074.productslist.domain.repository.ProductsRepository
import com.fyrl29074.productslist.data.mapper.ProductMapper
import com.fyrl29074.productslist.domain.useCase.GetProductsByPageUseCase
import com.fyrl29074.productslist.domain.useCase.GetProductsByPageUseCaseImpl

val ProductsListKoinModule = module {
    factoryOf(::ProductMapper)

    singleOf(::ProductsRepositoryImpl) bind ProductsRepository::class
    factoryOf(::GetProductsByPageUseCaseImpl) bind GetProductsByPageUseCase::class

    viewModelOf(::ProductsListViewModel)
}