package com.evapharma.medicinereminder.features.medicine_reminder.data.repo

import android.util.Log
import com.evapharma.medicinereminder.core.models.handleException
import com.evapharma.medicinereminder.core.models.handleResponse
import com.evapharma.medicinereminder.core.network.BaseURLFactory
import com.evapharma.medicinereminder.features.medicine_reminder.data.remote.MedicineApiService
import com.evapharma.medicinereminder.features.medicine_reminder.data.remote.MyFirebaseMessagingService
import com.evapharma.medicinereminder.features.medicine_reminder.data.remote.NotificationApiService
import com.evapharma.medicinereminder.features.medicine_reminder.domain.repo.NotificationRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NotificationRepoImpl @Inject constructor(
    private val firebaseMessagingService: MyFirebaseMessagingService,
) : NotificationRepo {
    override suspend fun getToken(): Flow<String> =
        firebaseMessagingService.getFirebaseToken().onEach { token ->
            sendTokenToApi(token)
        }

    private suspend fun sendTokenToApi(token: String) {
        withContext(Dispatchers.IO) {
            try {
                val response = BaseURLFactory.retrofit.create(
                    NotificationApiService::class.java
                ).sendTokenToServer(token) // Send token to your API

            } catch (e: Exception) {
                Log.e("NotificationRepository", "Error sending token to API: ${e.message}")
            }
        }
    }
}
