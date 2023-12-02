package com.shahtott.sh_news_app.data.repositoryImpl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.shahtott.sh_news_app.data.remote.api.NewsApi
import com.shahtott.sh_news_app.data.remote.paging.NewsPagingSource
import com.shahtott.sh_news_app.domain.model.Article
import com.shahtott.sh_news_app.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val api: NewsApi
) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
     return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    api,
                    sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

}