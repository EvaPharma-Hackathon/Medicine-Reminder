package com.evapharma.medicinereminder.features.medicine_reminder.presentation.intents

import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.status

sealed class MedicineListIntent {
    data object LoadMedicineList : MedicineListIntent()
    data class UpdateMedicine (val updateMedicine: MedicineUpdateRequest): MedicineListIntent()
    data class UpdateMedicineStatus (val id: Int, val newStatus: status): MedicineListIntent()
}