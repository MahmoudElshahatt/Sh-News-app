package com.shahtott.sh_news_app.domain.useCase.news

import com.shahtott.sh_news_app.domain.model.ArticleEntity
import com.shahtott.sh_news_app.domain.repository.ArticlesRepository

class SelectArticleUseCase(
    private val articlesRepository: ArticlesRepository
) {
    operator fun invoke(url: String): ArticleEntity? {
        return articlesRepository.getArticle(url)
    }
}