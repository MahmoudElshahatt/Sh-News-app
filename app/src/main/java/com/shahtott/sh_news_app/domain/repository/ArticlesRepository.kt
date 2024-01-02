package com.shahtott.sh_news_app.domain.repository


import com.shahtott.sh_news_app.data.local.room.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

interface ArticlesRepository {

    suspend fun upsertArticle(article: ArticleEntity)

    fun getArticle(url: String): ArticleEntity?

    suspend fun deleteArticle(article: ArticleEntity)

    fun getAllArticles(): Flow<List<ArticleEntity>>

}