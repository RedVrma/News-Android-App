package com.puneetverma.antinolabspuneetverma.rest.api

import com.puneetverma.antinolabspuneetverma.rest.models.NewsModel
import retrofit2.http.GET

interface NewsApi {

    @GET("top-headlines?country=in&apiKey=e8583650b4c64cef9b3cbec33508a2c0")
    suspend fun getNews():NewsModel
}