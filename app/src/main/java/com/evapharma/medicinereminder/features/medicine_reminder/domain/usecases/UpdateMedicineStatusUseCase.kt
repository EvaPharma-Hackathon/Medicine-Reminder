package com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases

import com.evapharma.medicinereminder.features.medicine_reminder.data.model.status
import com.evapharma.medicinereminder.features.medicine_reminder.data.repository.MedicineRepository
import javax.inject.Inject

class UpdateMedicineStatusUseCase @Inject constructor(private val repository: MedicineRepository) {

    fun invoke(id: Int, newStatus: status) {
        repository.updateStatus(
            id,
            newStatus
        )

    }
}