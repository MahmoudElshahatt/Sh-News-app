package com.shahtott.sh_news_app.data.repositoryImpl

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.shahtott.sh_news_app.data.local.PreferenceKeys
import com.shahtott.sh_news_app.data.local.dataStore
import com.shahtott.sh_news_app.domain.repository.LocalUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserRepositoryImpl(
    private val context: Context
) : LocalUserRepository {

    override suspend fun saveAppEntry() {
        context.dataStore.edit { settings ->
            settings[PreferenceKeys.APP_ENTRY] = true
        }
    }

    override fun getAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map{ preferences ->
            preferences[PreferenceKeys.APP_ENTRY] ?: false
        }
    }
}

