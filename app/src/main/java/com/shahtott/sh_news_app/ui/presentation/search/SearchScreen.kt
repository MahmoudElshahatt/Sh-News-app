package com.shahtott.sh_news_app.ui.presentation.search

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.shahtott.sh_news_app.ui.presentation.Dimens
import com.shahtott.sh_news_app.ui.presentation.Dimens.padding16
import com.shahtott.sh_news_app.ui.presentation.Dimens.padding24
import com.shahtott.sh_news_app.ui.presentation.common.ArticleList
import com.shahtott.sh_news_app.ui.presentation.common.MainEditBar
import com.shahtott.sh_news_app.ui.presentation.navgraph.Routes

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchNewsViewModel = hiltViewModel()
) {
    SearchContent(
        viewModel.state.value,
        viewModel::onEvent
    ) {
        navController.navigate(it)
    }
}

@Composable
fun SearchContent(
    state: SearchState,
    event: (SearchEvent) -> Unit,
    navigate: (String) -> Unit
) {
    val focusRequester = FocusRequester()

    Column(
        modifier = Modifier
            .padding(
                top = padding24,
                start = padding16,
                end = padding16
            )
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        MainEditBar(
            modifier = Modifier
                .height(50.dp)
                .focusRequester(focusRequester),
            text = state.searchQuery,
            readOnly = false,
            onValueChanged = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = { event(SearchEvent.SearchNews) }
        )

        Spacer(modifier = Modifier.height(padding24))

        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticleList(
                articles = articles
            ) {
                navigate(Routes.DetailsScreen.route)
            }
        }
    }
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewSearchNews() {
    SearchContent(SearchState(), {}, {})
}