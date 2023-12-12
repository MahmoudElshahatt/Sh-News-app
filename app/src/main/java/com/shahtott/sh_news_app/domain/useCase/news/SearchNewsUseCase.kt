package com.shahtott.sh_news_app.domain.useCase.news

import com.shahtott.sh_news_app.domain.repository.NewsRepository

class SearchNewsUseCase(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>) =
        newsRepository.searchNews(searchQuery, sources)
}