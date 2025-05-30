package com.example.sharedbooking

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.sharedbooking.entities.User
import com.example.sharedbooking.fragments.ChatsFragment
import com.example.sharedbooking.fragments.FilterFragment
import com.example.sharedbooking.fragments.HomeFragment
import com.example.sharedbooking.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        val prefs = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val isRegistered = prefs.getBoolean("isRegistered", false)


        if (!isRegistered) {
            startActivity(Intent(this, RegistrationActivity::class.java))
            finish()
            return
        }else{
            CurrentUser.user = getUserFromPrefs()
        }
        setContentView(R.layout.activity_main)

        val openFragment = intent.getStringExtra("openFragment")
        if (openFragment == "chats") {
            loadFragment(ChatsFragment())
        }

        val navigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
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

    private fun getUserFromPrefs(): User? {
        val prefs = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val gson = Gson()
        val userJson = prefs.getString("user_json", null)
        return if (userJson != null) {
            gson.fromJson(userJson, User::class.java)
        } else {
            null
        }
    }
}