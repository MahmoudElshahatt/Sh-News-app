package com.shahtott.sh_news_app.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shahtott.sh_news_app.data.local.room.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertArticle(articleEntity: ArticleEntity)


    @Delete
    suspend fun deleteArticle(articleEntity: ArticleEntity)

    @Query("SELECT * FROM ArticleEntity")
    fun getArticles(): Flow<List<ArticleEntity>>

    @Query("SELECT * FROM ArticleEntity WHERE url=:url")
    fun getArticle(url: String): ArticleEntity?
}