package com.shahtott.sh_news_app.ui.domain.repository

import kotlinx.coroutines.flow.Flow


interface LocalUserRepository {

    suspend fun saveAppEntry()

    fun getAppEntry(): Flow<Boolean>
}