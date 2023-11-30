package com.shahtott.sh_news_app.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shahtott.sh_news_app.data.remote.api.NewsApi
import com.shahtott.sh_news_app.domain.model.Article
import com.shahtott.sh_news_app.ui.util.Constants

class NewsPagingSource(
    private val newsApi: NewsApi,
    private val sources: String,
) : PagingSource<Int, Article> {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            val newsResponse =
                newsApi.getNews(sources = sources, page = page)

        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(
                e
            )
        }
    }
}