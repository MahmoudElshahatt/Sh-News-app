package com.shahtott.sh_news_app.domain.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    val author: String? = "",
    val content: String? = "",
    val description: String? = "",
    val publishedAt: String? = "",
    val source: Source? = Source(),
    val title: String? = "",
    val url: String? = "",
    val urlToImage: String? = ""
)