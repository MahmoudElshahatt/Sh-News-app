package com.shahtott.sh_news_app.domain.useCase.news

import com.shahtott.sh_news_app.data.local.room.NewsDao
import com.shahtott.sh_news_app.domain.model.ArticleEntity

class DeleteArticleUseCase(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: ArticleEntity) {
        newsDao.deleteArticle(article)
    }
}