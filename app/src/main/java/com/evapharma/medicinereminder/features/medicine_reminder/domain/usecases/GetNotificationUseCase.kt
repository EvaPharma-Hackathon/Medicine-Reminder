package com.evapharma.medicinereminder.domain

import com.evapharma.medicinereminder.data.NotificationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNotificationsUseCase @Inject constructor(
    private val repository: NotificationRepository
) {
    fun invoke(): Flow<String> = repository.getToken()
}
