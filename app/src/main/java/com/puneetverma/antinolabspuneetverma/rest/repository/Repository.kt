package com.puneetverma.antinolabspuneetverma.rest.repository

import com.puneetverma.antinolabspuneetverma.rest.api.RetrofitInstance
import com.puneetverma.antinolabspuneetverma.rest.models.NewsModel

class Repository {
    suspend fun getNews(): NewsModel {
        return RetrofitInstance.api.getNews()
    }

}