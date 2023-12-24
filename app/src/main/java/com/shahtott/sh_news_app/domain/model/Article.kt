package com.shahtott.sh_news_app.domain.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Article(
    @SerializedName("author")
    val author: String? = "", // Joel Khalili
    @SerializedName("content")
    val content: String? = "", // The prospect that US residents may soon be able to invest in bitcoin through their brokerage, as if it were a regular stock, has prompted a fresh round of hype in crypto circlesand a surge in crypto … [+2137 chars]
    @SerializedName("description")
    val description: String? = "", // After crashes, scandals, and SBF’s guilty verdict, many hoped the crypto industry would grow up. Speculation around the arrival of a spot bitcoin ETF shows old hype dies hard.
    @SerializedName("publishedAt")
    val publishedAt: String? = "", // 2023-11-29T12:00:00Z
    @SerializedName("source")
    val source: Source? = Source(),
    @SerializedName("title")
    val title: String? = "", // Fresh Bitcoin Hype Shows Crypto Just Can’t Help Itself
    @SerializedName("url")
    val url: String? = "", // https://www.wired.com/story/bitcoin-etf-crypto-investments/
    @SerializedName("urlToImage")
    val urlToImage: String? = "" // https://media.wired.com/photos/65668f0cb38d7a2373721a48/191:100/w_1280,c_limit/Crpyto-Can't-Help-Itself-Business-1400047284.jpg
) : Parcelable

fun List<ArticleEntity>.mapToArticles() =
    map {
        Article(
            author = it.author,
            content = it.content,
            description = it.description,
            publishedAt = it.publishedAt,
            source = it.source,
            title = it.title,
            url = it.url,
            urlToImage = it.urlToImage
        )
    }