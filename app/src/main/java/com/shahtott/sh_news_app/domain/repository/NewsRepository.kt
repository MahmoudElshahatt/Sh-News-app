package com.shahtott.sh_news_app.domain.repository

import androidx.paging.PagingData
import com.shahtott.sh_news_app.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources:List<String>): Flow<PagingData<Article>>

}