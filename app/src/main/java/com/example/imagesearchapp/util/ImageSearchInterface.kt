package com.example.imagesearchapp.util

import com.example.imagesearchapp.data.model.ImgSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ImageSearchInterface {
    @GET("v2/search/image")
    suspend fun getImage(@QueryMap param: HashMap<String, String>): Response<ImgSearchResponse>
}