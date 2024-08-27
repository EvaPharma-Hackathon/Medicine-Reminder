package com.evapharma.medicinereminder.features.auth.data.local

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.evapharma.medicinereminder.core.utils.Constants
import javax.inject.Inject


class AuthLocalDataSourceImpl @Inject constructor(context: Context) : AuthLocalDataSource {

    private val preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)


    override suspend fun saveToken(token: String) =
        preferences.edit().putString(Constants.BEARER, token).apply()

    override suspend fun getToken(): String? = preferences.getString(Constants.BEARER, null)

}