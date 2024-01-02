package com.shahtott.sh_news_app.ui.presentation.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.shahtott.sh_news_app.domain.model.Article
import com.shahtott.sh_news_app.domain.useCase.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val newsUseCase: NewsUseCases
) : ViewModel() {

    var sideEffect by mutableStateOf<String?>(null)
        private set

    fun onEvent(event: DetailsEvent) {
        when (event) {
            is DetailsEvent.UpsertDeleteArticle -> {
                CoroutineScope(Dispatchers.IO).launch {
                    val article =
                        newsUseCase.selectArticleUseCase(event.article.url ?: "")
                    if (article == null) {
                        upsertArticle(event.article)
                    } else {
                        deleteArticle(event.article)
                    }
                }
            }

            DetailsEvent.RemoveSideEffect -> {
                sideEffect = null
            }
        }
    }

    private suspend fun upsertArticle(article: Article) {
        newsUseCase.upsertArticleUseCase(article)
        sideEffect = "Article Saved in Bookmark"
    }

    private suspend fun deleteArticle(article: Article) {
        newsUseCase.deleteArticleUseCase(article)
        sideEffect = "Article Deleted from Bookmark"
    }

}