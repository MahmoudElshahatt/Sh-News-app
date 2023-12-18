package com.shahtott.sh_news_app.domain.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity
data class ArticleEntity(
    val author: String? = "",
    val content: String? = "",
    val description: String? = "",
    val publishedAt: String? = "",
    val source: Source? = Source(),
    val title: String? = "",
    @PrimaryKey
    val url: String = "",
    val urlToImage: String? = "",
)