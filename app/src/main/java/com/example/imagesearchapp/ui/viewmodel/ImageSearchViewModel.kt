package com.example.imagesearchapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagesearchapp.data.model.SearchResponse
import com.example.imagesearchapp.data.repository.ImageSearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class ImageSearchViewModel(
    private val imageSearchRepository: ImageSearchRepository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    // API
    private val _searchResult = MutableLiveData<SearchResponse>()
    val searchResult: LiveData<SearchResponse> get() = _searchResult

    fun searchImages(query: String) = viewModelScope.launch(Dispatchers.IO){
        val response:Response<SearchResponse> = imageSearchRepository.searchImages(query, "accuracy",1, 10)
        if (response.isSuccessful){
            response.body()?.let { body ->
                _searchResult.postValue(body)
            }
        }
    }
    // savedState
    var query = String()
        set(value) {
            field = value
            savedStateHandle.set(SAVE_STATE_KEY, value)
        }

    init {
        query = savedStateHandle.get<String>(SAVE_STATE_KEY) ?: ""
    }

    companion object {
        private const val SAVE_STATE_KEY = "query"
    }
}