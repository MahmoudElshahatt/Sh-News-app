package com.shahtott.sh_news_app.ui.util

import android.content.Context
import android.content.Intent
import android.net.Uri

fun browseUrl(
    url: String,
    context: Context
) {
    Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse(url)
        if (resolveActivity(context.packageManager) != null) {
            context.startActivity(this)
        }
    }
}