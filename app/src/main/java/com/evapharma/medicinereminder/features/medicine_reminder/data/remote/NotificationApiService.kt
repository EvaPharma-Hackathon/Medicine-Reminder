package com.evapharma.medicinereminder.features.medicine_reminder.data.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NotificationApiService {
    @POST("your/api/endpoint")
    suspend fun sendTokenToServer(@Body token: String): Response<Void>
}