package com.shahtott.sh_news_app.ui.presentation.bookmark

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shahtott.sh_news_app.R
import com.shahtott.sh_news_app.domain.model.Article
import com.shahtott.sh_news_app.domain.model.Source
import com.shahtott.sh_news_app.ui.presentation.Dimens.padding16
import com.shahtott.sh_news_app.ui.presentation.common.ArticleList
import com.shahtott.sh_news_app.ui.presentation.details.DetailsContent
import com.shahtott.sh_news_app.ui.presentation.navgraph.Routes
import com.shahtott.sh_news_app.ui.theme.ShNewsappTheme

@Composable
fun BookmarkScreen(
    navigateToDetails: (Article) -> Unit,
    viewModel: BookmarkViewModel = hiltViewModel(),
) {
    BookmarkContent(
        state = viewModel.state.value,
        navigateToDetails = navigateToDetails
    )
}


@Composable
private fun BookmarkContent(
    state: BookmarkState,
    navigateToDetails: (Article) -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(top = padding16, start = padding16, end = padding16)
    ) {
        Text(
            text = "Bookmark",
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.text_title)
        )

        Spacer(modifier = Modifier.height(padding16))

        ArticleList(articles = state.articles, onClick = {
            navigateToDetails(it)
        }
        )
    }
}

@Composable
@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
private fun PreviewBookmarkScreen() {
    ShNewsappTheme {
        Surface {
            BookmarkContent(state = BookmarkState(
                articles = listOf(
                    Article(
                        author = "",
                        title = "Coinbase says Apple blocked its last app release on NFTs in Wallet ... - CryptoSaurus",
                        description = "Coinbase says Apple blocked its last app release on NFTs in Wallet ... - CryptoSaurus",
                        content = "We use cookies and data to Deliver and maintain Google services Track outages and protect against spam, fraud, and abuse Measure audience engagement and site statistics to unde… [+1131 chars]",
                        publishedAt = "2023-06-16T22:24:33Z",
                        source = Source(
                            id = "", name = "bbc"
                        ),
                        url = "https://consent.google.com/ml?continue=https://news.google.com/rss/articles/CBMiaWh0dHBzOi8vY3J5cHRvc2F1cnVzLnRlY2gvY29pbmJhc2Utc2F5cy1hcHBsZS1ibG9ja2VkLWl0cy1sYXN0LWFwcC1yZWxlYXNlLW9uLW5mdHMtaW4td2FsbGV0LXJldXRlcnMtY29tL9IBAA?oc%3D5&gl=FR&hl=en-US&cm=2&pc=n&src=1",
                        urlToImage = "https://media.wired.com/photos/6495d5e893ba5cd8bbdc95af/191:100/w_1280,c_limit/The-EU-Rules-Phone-Batteries-Must-Be-Replaceable-Gear-2BE6PRN.jpg"
                    )
                )
            ), navigateToDetails = {})
        }
    }
}