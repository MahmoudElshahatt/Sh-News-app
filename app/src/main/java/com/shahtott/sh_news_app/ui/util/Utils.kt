package com.shahtott.sh_news_app.ui.util

import android.content.Context
import android.content.Intent
import android.net.Uri

fun browseUrl(
    context: Context,
    url: String
) {
    Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse(url)
        if (resolveActivity(context.packageManager) != null) {
            context.startActivity(this)
        }
    }
}

fun shareText(
    context: Context,
    textToShare: String
) {
    Intent(Intent.ACTION_SEND).apply {
        putExtra(Intent.EXTRA_TEXT, textToShare)
        type = "text/plain"
        if (resolveActivity(context.packageManager) != null) {
            context.startActivity(this)
        }
    }
}