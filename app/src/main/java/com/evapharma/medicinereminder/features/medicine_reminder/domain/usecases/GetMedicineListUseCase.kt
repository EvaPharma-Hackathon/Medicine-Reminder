package com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases

import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.repository.MedicineRepository

class GetMedicineListUseCase(private val repository: MedicineRepository) {

    fun execute(): List<Medicine> {
        return repository.getMedicineList()
    }
}