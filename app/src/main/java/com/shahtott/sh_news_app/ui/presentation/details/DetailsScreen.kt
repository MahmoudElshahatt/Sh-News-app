package com.shahtott.sh_news_app.ui.presentation.details

import android.content.res.Configuration
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.shahtott.sh_news_app.domain.model.Article
import com.shahtott.sh_news_app.ui.theme.ShNewsappTheme

@Composable
fun DetailsScreen() {

}

@Composable
fun DetailsContent(
    article: Article,
    onEvent: (DetailsEvent) -> Unit,
    navigateUp: () -> Unit
) {

}

@Composable
@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
private fun PreviewDetailsScreen() {
    ShNewsappTheme {
        Surface {
            DetailsContent(Article(), {}){}
        }
    }

}