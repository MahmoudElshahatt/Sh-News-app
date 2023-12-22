package com.shahtott.sh_news_app.domain.useCase.news

import com.shahtott.sh_news_app.data.local.room.NewsDao
import com.shahtott.sh_news_app.domain.model.ArticleEntity
import kotlinx.coroutines.flow.Flow

class SelectArticlesUseCase(
    private val newsDao: NewsDao
) {
    operator fun invoke(): Flow<List<ArticleEntity>> {
        return newsDao.getArticles()
    }
}