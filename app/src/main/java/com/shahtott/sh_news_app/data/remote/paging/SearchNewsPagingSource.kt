package com.shahtott.sh_news_app.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shahtott.sh_news_app.data.remote.api.NewsApi
import com.shahtott.sh_news_app.domain.model.Article

class SearchNewsPagingSource(
    private val newsApi: NewsApi,
    private val sources: String,
) : PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        TODO("Not yet implemented")
    }

}