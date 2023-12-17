package com.shahtott.sh_news_app.ui.presentation.details

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.shahtott.sh_news_app.domain.model.Article
import com.shahtott.sh_news_app.ui.presentation.common.TopBar
import com.shahtott.sh_news_app.ui.theme.ShNewsappTheme
import com.shahtott.sh_news_app.ui.util.browseUrl

@Composable
fun DetailsScreen() {

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
                browseUrl(article.url ?: "", context)
            },
            onShareClick = { /*TODO*/ },
            onBookmarkClick = { /*TODO*/ },
            onBackClick = {

            })
    }
}


@Composable
@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
private fun PreviewDetailsScreen() {
    ShNewsappTheme {
        Surface {
            DetailsContent(Article(), {}) {}
        }
    }

}