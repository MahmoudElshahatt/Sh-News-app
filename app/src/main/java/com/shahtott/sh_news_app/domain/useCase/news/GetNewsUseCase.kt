package com.shahtott.sh_news_app.domain.useCase.news

import com.shahtott.sh_news_app.domain.repository.NewsRepository


class GetNewsUseCase(
    private val newsRepository: NewsRepository
) {
      operator fun invoke(sources: List<String>) =
        newsRepository.getNews(sources)
}