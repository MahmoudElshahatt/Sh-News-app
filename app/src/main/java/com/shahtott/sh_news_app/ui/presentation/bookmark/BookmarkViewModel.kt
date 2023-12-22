package com.shahtott.sh_news_app.ui.presentation.bookmark

import androidx.lifecycle.ViewModel
import com.shahtott.sh_news_app.domain.useCase.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class BookmarkViewModel @Inject constructor(
    private val newsUseCase: NewsUseCases
) : ViewModel() {

}