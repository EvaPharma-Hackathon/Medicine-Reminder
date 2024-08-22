package com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases

import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.frequencyType
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.periodType
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.status
import com.evapharma.medicinereminder.features.medicine_reminder.data.repository.MedicineRepository
import javax.inject.Inject

class UpdateMedicineUseCase @Inject constructor(private val repository: MedicineRepository) {

   operator fun invoke(medicineId: Int, newStatus: status, time: String?, durationFrom: String?, durationTo: String?) {
         repository.updateMedicine(
             medicineId ,
            newStatus ,
             time ,
             durationFrom ,
             durationTo
             )

    }
}