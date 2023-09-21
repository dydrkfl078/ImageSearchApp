package com.example.imagesearchapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.imagesearchapp.R
import com.example.imagesearchapp.data.repository.ImageSearchRepository
import com.example.imagesearchapp.data.repository.ImageSearchRepositoryImpl
import com.example.imagesearchapp.databinding.ActivityMainBinding
import com.example.imagesearchapp.ui.viewmodel.ImageSearchViewModel
import com.example.imagesearchapp.ui.viewmodel.ImageSearchViewModelProviderFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var imageSearchViewModel: ImageSearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigationView()
        if (savedInstanceState == null){
            binding.bottomNavigationView.selectedItemId = R.id.bottom_btn_search
        }

        val imageSearchRepository = ImageSearchRepositoryImpl()
        val factory = ImageSearchViewModelProviderFactory(imageSearchRepository)
        imageSearchViewModel = ViewModelProvider(this,factory)[ImageSearchViewModel::class.java]
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