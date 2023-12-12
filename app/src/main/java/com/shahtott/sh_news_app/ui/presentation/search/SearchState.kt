package com.shahtott.sh_news_app.ui.presentation.search

import androidx.paging.PagingData
import com.shahtott.sh_news_app.domain.model.Article
import kotlinx.coroutines.flow.Flow


data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null,
)
