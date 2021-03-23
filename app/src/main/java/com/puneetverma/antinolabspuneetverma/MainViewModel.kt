package com.puneetverma.antinolabspuneetverma

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puneetverma.antinolabspuneetverma.rest.models.NewsModel
import com.puneetverma.antinolabspuneetverma.rest.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository):ViewModel() {

    val MyResponse: MutableLiveData<NewsModel> = MutableLiveData()

    fun getNews()
    {
        viewModelScope.launch {
            val response:NewsModel = repository.getNews()
            MyResponse.value = response
        }
    }
}