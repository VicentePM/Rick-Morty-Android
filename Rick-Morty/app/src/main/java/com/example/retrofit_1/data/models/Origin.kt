package com.example.retrofit_1.data.models


import com.squareup.moshi.Json

data class Origin(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)