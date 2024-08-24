package com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases

import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.domain.repo.MedicineRepo
import javax.inject.Inject

class GetMedicineListUseCase @Inject constructor(private val repository: MedicineRepo) {

    suspend operator fun invoke(): DataState<List<Medicine>> =
        repository.getMedicineList()
}
