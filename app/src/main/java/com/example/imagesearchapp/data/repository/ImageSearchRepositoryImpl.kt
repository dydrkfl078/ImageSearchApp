package com.example.imagesearchapp.data.repository

import com.example.imagesearchapp.data.api.RetrofitInstance.api
import com.example.imagesearchapp.data.model.SearchResponse
import retrofit2.Response

class ImageSearchRepositoryImpl : ImageSearchRepository {
    override suspend fun searchImages(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<SearchResponse> {
        return api.searchImages(query, sort, page, size)
    }
}