package com.example.imagesearchapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.imagesearchapp.R
import com.example.imagesearchapp.data.repository.ImageSearchRepository
import com.example.imagesearchapp.data.repository.ImageSearchRepositoryImpl
import com.example.imagesearchapp.databinding.ActivityMainBinding
import com.example.imagesearchapp.ui.viewmodel.ImageSearchViewModel
import com.example.imagesearchapp.ui.viewmodel.ImageSearchViewModelProviderFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var imageSearchViewModel: ImageSearchViewModel
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()

        val imageSearchRepository = ImageSearchRepositoryImpl()
        val factory = ImageSearchViewModelProviderFactory(imageSearchRepository, this)
        imageSearchViewModel = ViewModelProvider(this,factory)[ImageSearchViewModel::class.java]
    }
    private fun setupNavigation() {
        val host = supportFragmentManager
            .findFragmentById(R.id.imagesearch_nav_host_fragment) as NavHostFragment ?: return
        navController = host.navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }

}