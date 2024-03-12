package com.fyrl29074.network.di

import com.fyrl29074.network.api.ProductsApi
import com.fyrl29074.network.api.ServerInfo
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val NetworkKoinModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(ServerInfo.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductsApi::class.java)
    }
}