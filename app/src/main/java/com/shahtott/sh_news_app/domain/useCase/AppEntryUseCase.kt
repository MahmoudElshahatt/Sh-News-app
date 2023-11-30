package com.shahtott.sh_news_app.domain.useCase

data class AppEntryUseCase(
    val saveAppEntryUseCase: SaveAppEntryUseCase,
    val getAppEntryUseCase: GetAppEntryUseCase
)
