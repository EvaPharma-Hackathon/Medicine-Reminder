package com.evapharma.medicinereminder.features.auth.data.local

interface AuthLocalDataSource {
    suspend fun saveToken(token: String)

    suspend fun getToken(): String?
}
