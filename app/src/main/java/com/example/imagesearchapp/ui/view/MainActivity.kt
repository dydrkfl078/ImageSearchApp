package com.example.imagesearchapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigationView()
    }

    private fun setupBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_btn_search -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frameLayout, SearchFragment())
                        .commit()
                    true
                }
                R.id.bottom_btn_favorite -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frameLayout, FavoriteFragment())
                        .commit()
                    true
                }
                R.id.bottom_btn_settings -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frameLayout, SettingsFragment())
                        .commit()
                    true
                }
                else -> false

            }
        }

    }
}