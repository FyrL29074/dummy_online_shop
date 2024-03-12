package com.fyrl29074.dummy_online_shop.app

import android.app.Application

class App: Application() {

    private val koin = KoinInitializer()

    override fun onCreate() {
        super.onCreate()

        koin.init(this)
    }
}