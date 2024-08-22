package com.evapharma.medicinereminder.features.medicine_reminder.domain.repo

import kotlinx.coroutines.flow.Flow

interface NotificationRepo {

    suspend fun getToken(): Flow<String>
}