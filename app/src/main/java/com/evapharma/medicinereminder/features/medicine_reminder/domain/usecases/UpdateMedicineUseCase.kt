package com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases

import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.domain.repositry.MedicineRepo
import javax.inject.Inject

class UpdateMedicineUseCase @Inject constructor(private val repository: MedicineRepo) {

    suspend operator fun invoke(updateRequest: MedicineUpdateRequest) =
        repository.updateMedicine(
            updateRequest
        )

}