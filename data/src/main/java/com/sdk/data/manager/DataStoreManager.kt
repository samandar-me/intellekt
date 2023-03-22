package com.sdk.data.manager

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

class DataStoreManager(
    private val context: Context
) {
    private val Context.dataStore by preferencesDataStore("DataStoreManager")

    companion object {
        val IS_AUTHED = booleanPreferencesKey("isAuthed")
    }

    suspend fun saveAuthState(boolean: Boolean) {
        context.dataStore.edit {
            it[IS_AUTHED] = boolean
        }
    }

    fun getAuthState() = context.dataStore.data.map { it[IS_AUTHED] ?: false }
}