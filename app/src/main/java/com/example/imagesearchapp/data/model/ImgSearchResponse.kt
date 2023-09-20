package com.example.imagesearchapp.data.model

import com.google.gson.annotations.SerializedName

data class ImgSearchResponse(
    val documents: List<Document?>?,
    val meta: Meta?
)

data class Document(
    val collection: String?,
    val datetime: String?,
    val display_sitename: String?,
    val doc_url: String?,
    @SerializedName("height")
    val imgHeight: Int?,
    val image_url: String?,
    val thumbnail_url: String?,
    @SerializedName("width")
    val imgWidth: Int?
)

data class Meta(
    val is_end: Boolean?,
    val pageable_count: Int?,
    val total_count: Int?
)