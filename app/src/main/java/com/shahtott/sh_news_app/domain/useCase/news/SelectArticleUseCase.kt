package com.shahtott.sh_news_app.domain.useCase.news

import com.shahtott.sh_news_app.data.local.room.NewsDao
import com.shahtott.sh_news_app.domain.model.ArticleEntity

class SelectArticleUseCase(
    private val newsDao: NewsDao
) {
    operator fun invoke(url: String): ArticleEntity? {
        return newsDao.getArticle(url)
    }
}