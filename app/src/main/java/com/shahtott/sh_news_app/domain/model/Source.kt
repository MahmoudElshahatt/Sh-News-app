package com.shahtott.sh_news_app.domain.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Source(
    @SerializedName("id")
    val id: String? = "", // wired
    @SerializedName("name")
    val name: String? = "" // Wired
) : Parcelable