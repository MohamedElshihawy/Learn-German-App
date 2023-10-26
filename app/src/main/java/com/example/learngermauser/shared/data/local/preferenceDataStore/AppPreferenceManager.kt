package com.example.learngermauser.shared.data.local.preferenceDataStore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(
    name = "PreferenceDataStore",
)

class AppPreferenceManager(context: Context) {

    private val dataSource = context.dataStore

    val isFirstTimeLaunch: Flow<Boolean> = dataSource.data.map { preferences ->
        preferences[IS_FIRST_TIME_LAUNCH] ?: true
    }

    suspend fun setFirstTimeLaunch(isFirstTime: Boolean) {
        dataSource.edit { preferences ->
            preferences[IS_FIRST_TIME_LAUNCH] = isFirstTime
        }
    }

    val isOnBoardingDisplayedBefore: Flow<Boolean> = dataSource.data.map { preferences ->
        preferences[IS_ONBOARDING_DISPLAYED_BEFORE] ?: false
    }

    suspend fun setOnBoardingDisplayed(isFirstTime: Boolean) {
        dataSource.edit { preferences ->
            preferences[IS_ONBOARDING_DISPLAYED_BEFORE] = isFirstTime
        }
    }

    companion object {
        private val IS_FIRST_TIME_LAUNCH = booleanPreferencesKey("is_first_time_launch")
        private val IS_ONBOARDING_DISPLAYED_BEFORE =
            booleanPreferencesKey("is_onboarding_displayed_before")
    }
}
