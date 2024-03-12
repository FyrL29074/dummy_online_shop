package com.fyrl29074.dummy_online_shop.app

import android.content.Context
import com.fyrl29074.network.di.NetworkKoinModule
import com.fyrl29074.productslist.di.ProductsListKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinInitializer {

    private val allModules = listOf(
        NetworkKoinModule,
        ProductsListKoinModule,
    )

    fun init(appContext: Context) {
        startKoin {
            androidContext(appContext)
            modules(allModules)
        }
    }
}