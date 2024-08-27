package com.evapharma.medicinereminder.features.auth.data.remote

import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.features.auth.data.model.LoginRequest

interface AuthRemoteDataSource {
    suspend fun login(loginRequest: LoginRequest): DataState<String>

    suspend fun getFirebaseToken(): DataState<String>
}
