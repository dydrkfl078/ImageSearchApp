package com.example.imagesearchapp.data.api

import com.example.imagesearchapp.data.model.SearchResponse
import com.example.imagesearchapp.util.Constants.KAKAO_API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ImageSearchInterface {

    @Headers("Authorization: KakaoAK $KAKAO_API_KEY")
    @GET("v2/search/image")
    suspend fun searchImages(
        @Query("query") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): Response<SearchResponse>
}