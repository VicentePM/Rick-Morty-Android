package com.example.retrofit_1.data

import android.content.Context
import com.example.retrofit_1.data.network.RetrofitHelper

class Repository(val context: Context) {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getCharacters() = retrofit.getAllCharacters()
    suspend fun findForName(name: String) = retrofit.findForName(name)
    suspend fun findPageNumber(page: Int) = retrofit.findPageNumber(page)
    suspend fun findPageAndName(page: Int, name: String) = retrofit.findPageAndName(page, name)
}