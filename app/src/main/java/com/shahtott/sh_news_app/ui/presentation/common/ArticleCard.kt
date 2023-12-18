package com.shahtott.sh_news_app.ui.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.shahtott.sh_news_app.R
import com.shahtott.sh_news_app.domain.model.Article
import com.shahtott.sh_news_app.domain.model.Source
import com.shahtott.sh_news_app.ui.presentation.Dimens.ArticleCardSize
import com.shahtott.sh_news_app.ui.presentation.Dimens.ExtraSmallPadding2
import com.shahtott.sh_news_app.ui.presentation.Dimens.padding16
import com.shahtott.sh_news_app.ui.presentation.Dimens.SmallIconSize
import com.shahtott.sh_news_app.ui.theme.ShNewsappTheme

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: (Article) -> Unit
) {
    val context = LocalContext.current
    Row(modifier = modifier
        .clickable { onClick(article) }) {

        AsyncImage(
            modifier = Modifier
                .size(ArticleCardSize)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = padding16)
                .height(ArticleCardSize)
        ) {
            Text(
                text = article.title ?: "",
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 13.5.sp),
                color = colorResource(id = R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )


            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = article.source?.name ?: "",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body),
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Icon(
                    modifier = Modifier.size(SmallIconSize),
                    contentDescription = null,
                    painter = painterResource(id = R.drawable.ic_time),
                    tint = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Text(
                    text = article.publishedAt ?: "",
                    style = MaterialTheme.typography.labelSmall.copy(fontSize = 11.sp,
                        fontWeight = FontWeight.Medium),
                    color = colorResource(id = R.color.body),
                )
            }
        }
    }
}

@Composable
@Preview()
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun PreviewArticleCard() {
    ShNewsappTheme {
        Surface {
            ArticleCard(
                article = Article(
                    "dtftrtg", "gag", "regtye",
                    title = "kdldldlldldld",
                    source = Source("1", "ABC_MEDIA")
                )
            ) {

            }
        }
    }

}