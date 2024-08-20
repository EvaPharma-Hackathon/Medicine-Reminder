package com.evapharma.medicinereminder.data

import android.util.Log
import com.evapharma.medicinereminder.data.source.remote.MyFirebaseMessagingService
import com.evapharma.medicinereminder.features.medicine_reminder.data.source.remote.NotificationApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class NotificationRepository @Inject constructor(
    private val firebaseMessagingService: MyFirebaseMessagingService,
    private val postToken: NotificationApiService
) {
    fun getToken(): Flow<String> =
        firebaseMessagingService.getFirebaseToken().onEach { token ->
            sendTokenToApi(token)
        }

    private suspend fun sendTokenToApi(token: String) {
        try {
            val response = postToken.sendTokenToServer(token) // Send token to your API

        } catch (e: Exception) {
Log.e("NotificationRepository", "Error sending token to API: ${e.message}")        }
    }
}
