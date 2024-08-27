package com.evapharma.medicinereminder.features.auth.data.repo

import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.core.network.BaseURLFactory
import com.evapharma.medicinereminder.features.auth.data.local.AuthLocalDataSource
import com.evapharma.medicinereminder.features.auth.data.model.LoginRequest
import com.evapharma.medicinereminder.features.auth.data.remote.AuthRemoteDataSource
import com.evapharma.medicinereminder.features.auth.domain.repo.AuthRepo
import javax.inject.Inject

class AuthRepoImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
) : AuthRepo {

    override suspend fun login(loginRequest: LoginRequest): DataState<String> {


        val firebaseToken = authRemoteDataSource.getFirebaseToken()


        var response: DataState<String> = if (firebaseToken is DataState.Success) {

            authRemoteDataSource.login(loginRequest.copy(deviceToken = firebaseToken.data))

        } else {
            authRemoteDataSource.login(loginRequest)
        }

        if (response is DataState.Success) {
            BaseURLFactory.setAccessToken(response.data)
        }

        return response


    }
}