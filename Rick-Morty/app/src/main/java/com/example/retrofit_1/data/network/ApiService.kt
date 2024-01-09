package com.example.retrofit_1.data.network

import com.example.retrofit_1.data.models.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    suspend fun getAllCharacters(): Response<Result>

    @GET("character")
    suspend fun findForName(@Query("name") name: String) : Response<Result>

    @GET("character")
    suspend fun findPageNumber(@Query("page") page: Int) : Response<Result>

    @GET("characer")
    suspend fun findPageAndName(@Query("page") page: Int, @Query("name") name: String) : Response<Result>
}