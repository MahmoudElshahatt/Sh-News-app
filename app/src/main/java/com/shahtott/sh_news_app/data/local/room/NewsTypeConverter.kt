package com.shahtott.sh_news_app.data.local.room

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.shahtott.sh_news_app.domain.model.Source

@ProvidedTypeConverter
class NewsTypeConverter {
    @TypeConverter
    fun sourceToString(source: Source): String {
        return "${source.id},${source.name}"
    }

    @TypeConverter
    fun stringToSource(string: String): Source {
        return string.split(",").let {
            Source(id = it.component1(), name = it.component2())
        }
    }
}