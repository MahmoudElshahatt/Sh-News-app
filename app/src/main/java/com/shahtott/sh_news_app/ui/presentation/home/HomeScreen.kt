package com.shahtott.sh_news_app.ui.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.shahtott.sh_news_app.R
import com.shahtott.sh_news_app.domain.model.Article
import com.shahtott.sh_news_app.ui.presentation.Dimens.padding16
import com.shahtott.sh_news_app.ui.presentation.Dimens.padding24
import com.shahtott.sh_news_app.ui.presentation.Dimens.padding4
import com.shahtott.sh_news_app.ui.presentation.Dimens.padding8
import com.shahtott.sh_news_app.ui.presentation.common.ArticleList
import com.shahtott.sh_news_app.ui.presentation.common.MainEditBar
import com.shahtott.sh_news_app.ui.presentation.navgraph.Routes

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeContent(viewModel.news.collectAsLazyPagingItems()) {
        navController.navigate(it)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(articles: LazyPagingItems<Article>, navigate: (String) -> Unit) {
    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83d\uDFE5 ") {
                        it.title ?: ""
                    }
            } else {
                ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = padding16)
            .statusBarsPadding()
    ) {
        Image(
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = padding4),
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(padding24))

        MainEditBar(
            modifier = Modifier
                .height(50.dp)
                .padding(horizontal = padding16),
            text = "",
            readOnly = true,
            onValueChanged = {},
            onClick = { navigate(Routes.SearchScreen.route) },
            onSearch = {}
        )

        Spacer(modifier = Modifier.height(padding16))

        Text(
            text = titles,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = padding16)
                .basicMarquee(),
            fontSize = 12.sp,
            color = colorResource(id = R.color.placeholder)
        )

        Spacer(modifier = Modifier.height(padding16))

        ArticleList(
            modifier = Modifier.padding(horizontal = padding8),
            articles = articles,
            onClick = {
                navigate(Routes.DetailsScreen.route)
            })

    }
}

