package com.example.retrofit_1.data.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitHelper {

    var retrofitService: ApiService? = null

    fun getRetrofit(): ApiService {

        if(retrofitService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

            retrofitService = retrofit.create(ApiService::class.java)
        }

        return retrofitService!!
    }
}