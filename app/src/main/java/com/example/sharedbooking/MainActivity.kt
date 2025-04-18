package com.example.sharedbooking

import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.sharedbooking.fragments.ChatsFragment
import com.example.sharedbooking.fragments.FilterFragment
import com.example.sharedbooking.fragments.HomeFragment
import com.example.sharedbooking.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        val navigation: BottomNavigationView  = findViewById(R.id.bottom_navigation)
        navigation.setOnNavigationItemSelectedListener {item ->
            when(item.itemId) {
                R.id.home_icon -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.filter_icon -> {
                    loadFragment(FilterFragment())
                    true
                }
                R.id.chat_icon -> {
                    loadFragment(ChatsFragment())
                    true
                }
                R.id.profile_icon -> {
                    loadFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
    }
}