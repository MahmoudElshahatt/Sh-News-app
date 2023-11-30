package com.shahtott.sh_news_app.domain.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Source(
    @SerializedName("id")
    val id: String? = "", // wired
    @SerializedName("name")
    val name: String? = "" // Wired
)