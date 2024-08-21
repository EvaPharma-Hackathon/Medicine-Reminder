package com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases

import com.evapharma.medicinereminder.features.medicine_reminder.domain.repositry.NotificationRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNotificationUseCase @Inject constructor(
    private val repository: NotificationRepo
) {
    suspend operator fun invoke(): Flow<String> = repository.getToken()
}
