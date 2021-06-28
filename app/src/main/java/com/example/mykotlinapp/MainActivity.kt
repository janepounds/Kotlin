package com.example.mykotlinapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var fragment_container: FragmentContainerView
    lateinit var context:Context
    lateinit var actionBar: ActionBar
    lateinit var fragmentManager: FragmentManager
    lateinit var toolbar:Toolbar


    private val bottomNavigationView by lazy {
        findViewById<BottomNavigationView>(R.id.bottom_navigation)
    }

    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_main)
        fragment_container =findViewById(R.id.nav_host_fragment)
        fragmentManager = supportFragmentManager
        toolbar = findViewById(R.id.main_toolbar)
        context = applicationContext
        setUpNavigation()
        setSupportActionBar(toolbar)
        actionBar = supportActionBar!!
        actionBar.setDisplayShowTitleEnabled(false)
        actionBar.setHomeButtonEnabled(false)
        actionBar.setDisplayHomeAsUpEnabled(false)
//        NavigationUI.setupWithNavController(bottomNavigationView, navController);

    }

    private fun setUpNavigation() {
        bottomNavigationView.itemIconTintList == null
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            var currentDestination: Int
            when (item.itemId) {
                R.id.navigation_home -> {
                    currentDestination = Navigation.findNavController(navHostFragment.requireView()).currentDestination!!.id


                }
                R.id.accountFragment2 -> {
                    currentDestination =  Navigation.findNavController(navHostFragment.requireView()).currentDestination!!.id
                    if (currentDestination == R.id.accountFragment2)
                        Navigation.findNavController(navHostFragment.requireView()).navigate(R.id.action_navigation_home_to_accountFragment2)
                }


            }
            true }
//        Navigation.findNavController(navHostFragment.requireView()).addOnNavigatedListener { controller, destination ->
//            bottomNavigationView.selectedItemId = destination.id
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        if (Navigation.findNavController(navHostFragment.requireView()).currentDestination!!.id!=R.id.navigation_home) {
            // Pop previous Fragment
            Navigation.findNavController(navHostFragment.requireView()).popBackStack();

        }else{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}