package com.shahtott.sh_news_app.data.repositoryImpl

import com.shahtott.sh_news_app.data.local.room.NewsDao
import com.shahtott.sh_news_app.data.local.room.entity.ArticleEntity
import com.shahtott.sh_news_app.domain.repository.ArticlesRepository
import kotlinx.coroutines.flow.Flow

class ArticlesRepositoryImpl(
    private val newsDao: NewsDao
) : ArticlesRepository {
    override suspend fun upsertArticle(article: ArticleEntity) {
        newsDao.upsertArticle(article)
    }

    override fun getArticle(url: String): ArticleEntity? {
        return newsDao.getArticle(url)
    }

    override suspend fun deleteArticle(article: ArticleEntity) {
        newsDao.deleteArticle(article)
    }

    override fun getAllArticles(): Flow<List<ArticleEntity>> {
        return newsDao.getArticles()
    }
}