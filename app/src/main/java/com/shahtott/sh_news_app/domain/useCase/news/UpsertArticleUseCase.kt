package com.shahtott.sh_news_app.domain.useCase.news

import com.shahtott.sh_news_app.domain.model.Article
import com.shahtott.sh_news_app.domain.model.ArticleEntity
import com.shahtott.sh_news_app.domain.model.mapToArticleEntity
import com.shahtott.sh_news_app.domain.repository.ArticlesRepository

class UpsertArticleUseCase(
    private val articlesRepository: ArticlesRepository
) {
    suspend operator fun invoke(article: Article) {
        articlesRepository.upsertArticle(article.mapToArticleEntity())
    }
}