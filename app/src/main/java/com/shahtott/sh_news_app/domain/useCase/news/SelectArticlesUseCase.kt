package com.shahtott.sh_news_app.domain.useCase.news

import com.shahtott.sh_news_app.domain.model.Article
import com.shahtott.sh_news_app.domain.model.mapToArticles
import com.shahtott.sh_news_app.domain.repository.ArticlesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SelectArticlesUseCase(
    private val articlesRepository: ArticlesRepository
) {
    operator fun invoke(): Flow<List<Article>> {
        return articlesRepository.getAllArticles().map {
            it.mapToArticles().reversed()
        }
    }
}