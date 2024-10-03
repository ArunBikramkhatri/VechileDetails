package com.nura.vechiledetails.ui.view

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nura.vechiledetails.R
import java.util.Objects

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigation: BottomNavigationView

    private  val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        bottomNavigation = findViewById(R.id.bottomNavigationView)
        val homeFragment = FirstFragment()
        val bikeComapniesFragment = BikeCompaniesFragment()

        loadFragment(homeFragment)
        bottomNavigation.setOnNavigationItemSelectedListener {
            try {
                when (it.itemId) {
                    R.id.home -> {
                        loadFragment(homeFragment)
                        true
                    }

                    R.id.companies -> {
                        loadFragment(bikeComapniesFragment)
                        true
                    }

                    else -> {
                        loadFragment(homeFragment)
                        true
                    }
                }
            } catch (e: Exception) {
                throw e
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadFragment(fragment : Fragment) {
        Objects.requireNonNull(fragment, "fragment is null")
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.appFrameLayout, fragment)
        transaction.commit()
    }
}