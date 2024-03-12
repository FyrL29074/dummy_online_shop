package com.fyrl29074.dummy_online_shop

import NavScreens
import Navigation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class MainActivity : AppCompatActivity(), Navigation {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun navigateTo(fragment: Fragment, screen: NavScreens) {
        val navID = when(screen) {
            NavScreens.ProductsList -> R.id.products_list
        }

        fragment.findNavController().navigate(navID)
    }
}