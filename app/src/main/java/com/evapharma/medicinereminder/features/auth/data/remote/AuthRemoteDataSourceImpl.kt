package com.evapharma.medicinereminder.features.auth.data.remote

import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.core.models.handleException
import com.evapharma.medicinereminder.core.models.handleResponse
import com.evapharma.medicinereminder.core.network.BaseURLFactory
import com.evapharma.medicinereminder.features.auth.data.model.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(
    private val firebaseMessagingService: MyFirebaseMessagingService
) : AuthRemoteDataSource {

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

    override suspend fun getFirebaseToken(): DataState<String> {
        val token = firebaseMessagingService.getFirebaseToken()
        if (token != null) {
            println("firebase token: ${token}")
            return DataState.Success(token)

        } else {
            println("firebase token failed: ${token}")
            return DataState.Error(reason = listOf("Failed to get firebase token"), code = 0)

        }
    }


}