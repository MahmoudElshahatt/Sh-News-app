package com.shahtott.sh_news_app.domain.useCase.news

data class NewsUseCases(
    val getNewsUseCase: GetNewsUseCase,
    val searchNewsUseCase: SearchNewsUseCase,
    val selectArticlesUseCase: SelectArticlesUseCase,
    val deleteArticleUseCase: DeleteArticleUseCase,
    val upsertArticleUseCase: UpsertArticleUseCase,
    val selectArticleUseCase: SelectArticleUseCase
)
