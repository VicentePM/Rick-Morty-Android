package com.example.retrofit_1.data.models


import com.squareup.moshi.Json

data class Result(
    @Json(name = "info")
    val info: Info,
    @Json(name = "results")
    val results: List<Character>
)