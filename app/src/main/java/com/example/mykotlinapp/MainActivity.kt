package com.example.mykotlinapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.mykotlinapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var fragment_container: FragmentContainerView
    lateinit var navController: NavController
    lateinit var context:Context
    lateinit var actionBar: ActionBar
    lateinit var navHostFragment:NavHostFragment
    lateinit var binding:ActivityMainBinding
    lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        fragment_container = binding.navigationHome
        fragmentManager = supportFragmentManager
        navHostFragment = (supportFragmentManager.findFragmentById(binding.navigationHome.id) as NavHostFragment?)!!
        navController = navHostFragment.navController
        context = applicationContext
        setUpNavigation()
        setSupportActionBar(binding.mainToolbar)
        actionBar = supportActionBar!!
        actionBar.setDisplayShowTitleEnabled(false)
        actionBar.setHomeButtonEnabled(false)
        actionBar.setDisplayHomeAsUpEnabled(false)
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController);

    }

    private fun setUpNavigation() {
        binding.bottomNavigation.itemIconTintList == null
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            var currentDestination: Int
            when (item.itemId) {
                R.id.navigation_home -> {
                    currentDestination = navController.currentDestination!!.id


                }
                R.id.accountFragment2 -> {
                    currentDestination = navController.currentDestination!!.id
                    if (currentDestination == R.id.accountFragment2)
                        navController.navigate(R.id.action_navigation_home_to_accountFragment2)
                }


            }
            true }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        if (navController.currentDestination!!.id!=R.id.navigation_home) {
            // Pop previous Fragment
            navController.popBackStack();

        }else{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}