package com.shahtott.sh_news_app.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.shahtott.sh_news_app.domain.model.ArticleEntity

@Database(
    entities = [ArticleEntity::class],
    version = 1
)
@TypeConverters(NewsTypeConverter::class)
abstract class NewsDatabase : RoomDatabase() {

}