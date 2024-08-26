package com.evapharma.medicinereminder.features.auth.data.remote

import com.evapharma.medicinereminder.Endpoints
import com.evapharma.medicinereminder.core.models.BaseResponse
import com.evapharma.medicinereminder.features.auth.data.model.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface AuthApiService {

    @POST(Endpoints.LOGIN)
    suspend fun login(@Body loginRequest: LoginRequest): Response<BaseResponse<String>>


}