package com.shahtott.sh_news_app.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shahtott.sh_news_app.data.remote.api.NewsApi
import com.shahtott.sh_news_app.domain.model.Article
import com.shahtott.sh_news_app.ui.util.Constants

class NewsPagingSource(
    private val newsApi: NewsApi,
    private val sources: String,
) : PagingSource<Int, Article>() {
    private var totalNewsCount = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            val newsResponse =
                newsApi.getNews(sources = sources, page = page)
            totalNewsCount += newsResponse.articles?.size ?: 0
            val articles =
                newsResponse.articles?.distinctBy { it?.title }?.filterNotNull()
                    ?: emptyList()  //distinctBy to remove duplicates.
            LoadResult.Page(
                data = articles,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1,
                prevKey = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(
                e
            )
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}