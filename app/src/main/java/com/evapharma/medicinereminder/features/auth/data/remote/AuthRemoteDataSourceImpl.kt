package com.evapharma.medicinereminder.features.auth.data.remote

import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.core.models.getDataState
import com.evapharma.medicinereminder.core.network.BaseURLFactory
import com.evapharma.medicinereminder.core.utils.Constants
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
                ).login(loginRequest = loginRequest).getDataState()
            } catch (t: Throwable) {
                DataState.Error(
                    reason = listOf(Constants.NO_INTERNET_ERROR),
                    code = Constants.LOCAL_ERROR_CODE
                )
            }
        }

    override suspend fun getFirebaseToken(): DataState<String> {
        val token = firebaseMessagingService.getFirebaseToken()
        return if (token != null) {
            DataState.Success(token)
        } else {
            DataState.Error(reason = listOf(Constants.NO_FIREBASE_TOKEN_ERROR), code = 0)

        }
    }


}