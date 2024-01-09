package com.example.retrofit_1.ui

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit_1.data.Repository
import com.example.retrofit_1.data.models.Character
import com.example.retrofit_1.data.models.Info
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(val context: Context) : ViewModel() {

    private val repository = Repository(context)

    val charactersLiveData = MutableLiveData<List<Character>?>()
    val selectedCharacter = MutableLiveData<Character>()
    val infoLiveData = MutableLiveData<Info>()

    fun getCharacters() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getCharacters()
            if(response.isSuccessful) {
                val myResponse = response.body()
                val characterList = myResponse?.results
                charactersLiveData.postValue(characterList)
                infoLiveData.postValue(myResponse?.info)
            }
        }
    }

    fun findForName(name: String){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.findForName(name)
            val code = response.code()
            if(code == 200) {
                val myResponse = response.body()
                val characterList = myResponse?.results
                charactersLiveData.postValue(characterList)
                infoLiveData.postValue(myResponse?.info)
            }
        }
    }

    fun findPageNumber(page: Int){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.findPageNumber(page)
            val code = response.code()
            if(code == 200) {
                val myResponse = response.body()
                val characterList = myResponse?.results
                charactersLiveData.postValue(characterList)
                infoLiveData.postValue(myResponse?.info)
            }
        }
    }

    fun findPageAndName(page: Int, name: String){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.findPageAndName(page, name)
            val code = response.code()
            if(code == 200) {
                val myResponse = response.body()
                val characterList = myResponse?.results
                charactersLiveData.postValue(characterList)
                infoLiveData.postValue(myResponse?.info)
            }
        }
    }

    class MyViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(Context::class.java).newInstance(context)
        }
    }
}