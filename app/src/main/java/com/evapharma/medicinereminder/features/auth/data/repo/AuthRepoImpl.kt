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
        if (authLocalDataSource.getToken() == null) {
            println("token is null")
            val response = authRemoteDataSource.login(loginRequest)
            println("response is $response")
            if (response is DataState.Success) {
                authLocalDataSource.saveToken(response.data)
                BaseURLFactory.setAccessToken(response.data)
            }
            return response
        } else {
            val token = authLocalDataSource.getToken()
            BaseURLFactory.setAccessToken(token!!)
            return DataState.Success(token)
        }
    }
}