package com.shahtott.sh_news_app.ui.data.repositoryImpl

import android.content.Context
import com.shahtott.sh_news_app.ui.domain.repository.LocalUserRepository
import kotlinx.coroutines.flow.Flow

class LocalUserRepositoryImpl(
    private val context: Context
):LocalUserRepository {
    override suspend fun saveAppEntry() {
        TODO("Not yet implemented")
    }

    override fun getAppEntry(): Flow<Boolean> {
        TODO("Not yet implemented")
    }
}