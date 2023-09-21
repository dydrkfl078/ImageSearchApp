package com.example.imagesearchapp.ui.viewmodel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.example.imagesearchapp.data.repository.ImageSearchRepository
import java.lang.IllegalArgumentException

class ImageSearchViewModelProviderFactory(
    private val imageSearchRepository: ImageSearchRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
): AbstractSavedStateViewModelFactory(owner,defaultArgs) {
    override fun <T : ViewModel> create(
        key : String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        if (modelClass.isAssignableFrom(ImageSearchViewModel::class.java)){
            return ImageSearchViewModel(imageSearchRepository,handle) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}