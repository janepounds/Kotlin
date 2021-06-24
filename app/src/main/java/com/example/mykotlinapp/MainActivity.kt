package com.example.mykotlinapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottom_nav: BottomNavigationView
    lateinit var fragment_container: FragmentContainerView
    lateinit var navController: NavController
    lateinit var navHostFragment:NavHostFragment
    lateinit var context:Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_nav = findViewById(R.id.bottom_navigation)
        fragment_container = findViewById(R.id.home_container)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.home_container) as NavHostFragment
        navController = navHostFragment.navController

        context = applicationContext
        setUpNavigation()

    }

    private fun setUpNavigation() {

    }
}