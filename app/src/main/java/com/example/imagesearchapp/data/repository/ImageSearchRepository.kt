package com.example.imagesearchapp.data.repository

import com.example.imagesearchapp.data.model.SearchResponse
import retrofit2.Response

interface ImageSearchRepository {
    suspend fun searchImages(
        query: String,
        sort: String,
        page: Int,
        size: Int,
    ): Response<SearchResponse>
}