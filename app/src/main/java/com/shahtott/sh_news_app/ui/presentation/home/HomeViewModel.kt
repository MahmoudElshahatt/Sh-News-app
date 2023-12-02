package com.shahtott.sh_news_app.ui.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.shahtott.sh_news_app.domain.useCase.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {
    val news = newsUseCases.getNewsUseCase(
        sources = listOf("abc-news", "bbc-news", "al-jazeera-english")
    ).cachedIn(viewModelScope)
}