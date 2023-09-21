package com.example.imagesearchapp.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Document(
    @field:Json(name = "collection")
    val collection: String,
    @field:Json(name = "datetime")
    val datetime: String,
    @field:Json(name = "display_sitename")
    val displaySitename: String,
    @field:Json(name = "doc_url")
    val docUrl: String,
    @field:Json(name = "height")
    val height: Int,
    @field:Json(name = "image_url")
    val imageUrl: String,
    @field:Json(name = "thumbnail_url")
    val thumbnailUrl: String,
    @field:Json(name = "width")
    val width: Int
)