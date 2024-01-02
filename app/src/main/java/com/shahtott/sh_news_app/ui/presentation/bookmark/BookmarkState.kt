package com.shahtott.sh_news_app.ui.presentation.bookmark

import com.shahtott.sh_news_app.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)
