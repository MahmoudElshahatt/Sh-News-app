package com.shahtott.sh_news_app.data.remote.dto


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.shahtott.sh_news_app.domain.model.Article

@Keep
data class NewsResponse(
    @SerializedName("articles")
    val articles: List<Article?>? = listOf(),
    @SerializedName("status")
    val status: String? = "", // ok
    @SerializedName("totalResults")
    val totalResults: Int? = 0 // 11608
)