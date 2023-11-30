package com.shahtott.sh_news_app.data.remote.api

import com.shahtott.sh_news_app.data.remote.dto.NewsResponse
import com.shahtott.sh_news_app.ui.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String= Constants.API_KEY
    ): NewsResponse

}