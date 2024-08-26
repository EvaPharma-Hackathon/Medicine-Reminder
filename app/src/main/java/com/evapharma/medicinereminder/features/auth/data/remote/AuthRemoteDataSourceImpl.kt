package com.evapharma.medicinereminder.features.auth.data.remote

import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.core.models.handleException
import com.evapharma.medicinereminder.core.models.handleResponse
import com.evapharma.medicinereminder.core.network.BaseURLFactory
import com.evapharma.medicinereminder.features.auth.data.model.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(): AuthRemoteDataSource {

    override suspend fun login(loginRequest: LoginRequest): DataState<String> =
        withContext(Dispatchers.IO) {
            try {
                BaseURLFactory.retrofit.create(
                    AuthApiService::class.java
                ).login(loginRequest = loginRequest).handleResponse()
            } catch (t: Throwable) {
                t.handleException()
            }
        }

}