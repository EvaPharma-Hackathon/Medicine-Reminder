package com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases

import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineStatusUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.domain.repositry.MedicineRepo
import javax.inject.Inject

class UpdateMedicineStatusUseCase @Inject constructor(private val repository: MedicineRepo) {

    suspend operator fun invoke(updateRequest: MedicineStatusUpdateRequest) =
        repository.updateStatus(updateRequest)

}