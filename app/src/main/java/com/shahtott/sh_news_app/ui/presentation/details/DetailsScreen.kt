package com.shahtott.sh_news_app.ui.presentation.details

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.shahtott.sh_news_app.R
import com.shahtott.sh_news_app.domain.model.Article
import com.shahtott.sh_news_app.domain.model.Source
import com.shahtott.sh_news_app.ui.presentation.Dimens
import com.shahtott.sh_news_app.ui.presentation.Dimens.ArticleImageSize
import com.shahtott.sh_news_app.ui.presentation.Dimens.padding24
import com.shahtott.sh_news_app.ui.presentation.common.TopBar
import com.shahtott.sh_news_app.ui.theme.ShNewsappTheme
import com.shahtott.sh_news_app.ui.util.browseUrl
import com.shahtott.sh_news_app.ui.util.shareText

@Composable
fun DetailsScreen(
    navController: NavController,
) {
//    DetailsContent(
//
//    )
}

@Composable
fun DetailsContent(
    article: Article,
    onEvent: (DetailsEvent) -> Unit,
    navigateUp: () -> Unit
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
    ) {
        TopBar(
            onBrowsing = {
                browseUrl(
                    url = article.url ?: "",
                    context = context
                )
            },
            onShareClick = {
                shareText(
                    textToShare = article.url ?: "",
                    context = context
                )
            },
            onBookmarkClick = {
                onEvent(DetailsEvent.SaveArticle)
            },
            onBackClick = navigateUp
        )
        //Scrollable to support all screen sizes.
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                start = Dimens.padding16,
                end = Dimens.padding16,
                top = Dimens.padding24,
            )
        ) {
            item {
                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .data(article.urlToImage).build(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ArticleImageSize)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(padding24))

                Text(
                    text = article.title ?: "",
                    style = MaterialTheme.typography.displaySmall,
                    color = colorResource(id = R.color.text_title)
                )

                Text(
                    text = article.content ?: "",
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.body)
                )
            }
        }
    }
}


@Composable
@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
private fun PreviewDetailsScreen() {
    ShNewsappTheme {
        Surface {
            DetailsContent(
                article = Article(
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
                ),
                onEvent = {},
                // sideEffect = null
            ) {

            }
        }
    }
}