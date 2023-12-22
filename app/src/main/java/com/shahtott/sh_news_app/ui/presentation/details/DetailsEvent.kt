package com.shahtott.sh_news_app.ui.presentation.details

import com.shahtott.sh_news_app.domain.model.Article

sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article:Article) : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()

}