package com.evapharma.medicinereminder.features.medicine_reminder.domain.repositry

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

interface NotificationRepo {

    suspend fun getToken(): Flow<String>
}