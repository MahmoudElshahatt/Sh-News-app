package com.shahtott.sh_news_app.data.local.room.entity

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shahtott.sh_news_app.domain.model.Article
import com.shahtott.sh_news_app.domain.model.Source

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

fun Article.mapToArticleEntity() = ArticleEntity(
    author = this.author,
    content = this.content,
    description = this.description,
    publishedAt = this.publishedAt,
    source = this.source,
    title = this.title,
    url = this.url ?: "",
    urlToImage = this.urlToImage
)

