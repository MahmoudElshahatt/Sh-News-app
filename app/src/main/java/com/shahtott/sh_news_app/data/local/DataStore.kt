package com.shahtott.sh_news_app.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.shahtott.sh_news_app.ui.util.Constants


private val readOnlyProperty = preferencesDataStore(name = Constants.USER_SETTINGS)


val Context.dataStore: DataStore<Preferences> by readOnlyProperty

object PreferenceKeys {
    val APP_ENTRY = booleanPreferencesKey(Constants.APP_ENTRY)
}