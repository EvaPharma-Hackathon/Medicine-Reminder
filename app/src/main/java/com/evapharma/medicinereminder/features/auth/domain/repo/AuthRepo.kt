package com.evapharma.medicinereminder.features.auth.domain.repo

import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.features.auth.data.model.LoginRequest

interface AuthRepo {
    suspend fun login(loginRequest: LoginRequest): DataState<String>

}