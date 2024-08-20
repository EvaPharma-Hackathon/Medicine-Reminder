package com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases

import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.repository.MedicineRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMedicineListUseCase @Inject constructor(private val repository: MedicineRepository) {

    fun invoke(): Flow<List<Medicine>> {
        return repository.getMedicineList()
    }
}